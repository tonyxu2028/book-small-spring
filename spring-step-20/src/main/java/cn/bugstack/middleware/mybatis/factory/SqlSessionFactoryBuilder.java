package cn.bugstack.middleware.mybatis.factory;

import cn.bugstack.middleware.mybatis.beans.Configuration;
import cn.bugstack.middleware.mybatis.beans.XNode;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.xml.sax.InputSource;

import java.io.InputStream;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description SqlSessionFactoryBuilder类包含的核心方法有
 * build(构建实例化元素),
 * parseConfiguration(解析配置文件),
 * dataSource(获取数据源配置),
 * connection(获取数据库连接 Map dataSource 链接数据库),
 * mapperElement(解析SQL语句)。
 * @author naixixu
 * @date 2022/3/16
 */
public class SqlSessionFactoryBuilder {

    private static final Pattern PATTERN = Pattern.compile("(#\\{(.*?)})");

    // ############################## 构建实例化元素 parseConfiguration ##############################

    /**
     * 构建SqlSessionFactory          (构建实例化元素)
     * @param reader                    配置文件
     * @return                          SqlSessionFactory
     */
    public DefaultSqlSessionFactory build(Reader reader) {
        SAXReader saxReader = new SAXReader();
        try {
            Document document = saxReader.read(new InputSource(reader));
            Configuration configuration = parseConfiguration(document.getRootElement());
            return new DefaultSqlSessionFactory(configuration);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    public DefaultSqlSessionFactory build(InputStream inputStream) {
        SAXReader saxReader = new SAXReader();
        try {
            Document document = saxReader.read(inputStream);
            Configuration configuration = parseConfiguration(document.getRootElement());
            return new DefaultSqlSessionFactory(configuration);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }

   // ############################## 解析配置 parseConfiguration ##############################

    /**
     * 解析配置文件
     * @param root                      根节点
     * @return                          Configuration
     */
    private Configuration parseConfiguration(Element root) {
        Configuration configuration = new Configuration();
        configuration.setDataSource(dataSource(root.element("environments").element("environment").element("dataSource")));
        configuration.setConnection(connection(configuration.dataSource));
        configuration.setMapperElement(mapperElement(root.element("mappers")));
        return configuration;
    }

    /**
     * 获取数据源配置信息
     * @param element                   数据源配置信息
     * @return                          数据源
     */
    private Map<String, String> dataSource(Element element) {
        Map<String, String> dataSource = new HashMap<>(4);
        List<Element> propertyList = element.elements("property");
        for (Element e : propertyList) {
            String name = e.attributeValue("name");
            String value = e.attributeValue("value");
            dataSource.put(name, value);
        }
        return dataSource;
    }

    // ############################## 链接数据库 connection ##############################

    private Connection connection(Map<String, String> dataSource) {
        try {
            Class.forName(dataSource.get("driver"));
            return DriverManager.getConnection(
                    dataSource.get("url"),
                    dataSource.get("username"),
                    dataSource.get("password"));
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // ############################## 解析SQL语句 mapperElement ##############################

    /**
     * 获取SQL语句信息
     * @param mappers               SQL语句信息
     * @return                      SQL语句信息
     */
    private Map<String, XNode> mapperElement(Element mappers) {
        Map<String, XNode> map = new HashMap<>(100);
        List<Element> mapperList = mappers.elements("mapper");
        for (Element e : mapperList) {
            String resource = e.attributeValue("resource");
            try {
                Reader reader = Resources.getResourceAsReader(resource);
                SAXReader saxReader = new SAXReader();
                Document document = saxReader.read(new InputSource(reader));
                Element root = document.getRootElement();
                //命名空间
                String namespace = root.attributeValue("namespace");
                // SELECT
                List<Element> selectNodes = root.elements("select");
                for (Element node : selectNodes) {
                    String id = node.attributeValue("id");
                    String parameterType = node.attributeValue("parameterType");
                    String resultType = node.attributeValue("resultType");
                    String sql = node.getText();

                    // ? 匹配
                    Map<Integer, String> parameter = new HashMap<>(100);

                    Matcher matcher = PATTERN.matcher(sql);
                    for (int i = 1; matcher.find(); i++) {
                        String g1 = matcher.group(1);
                        String g2 = matcher.group(2);
                        parameter.put(i, g2);
                        sql = sql.replace(g1, "?");
                    }

                    XNode xNode = new XNode();
                    xNode.setNamespace(namespace);
                    xNode.setId(id);
                    xNode.setParameterType(parameterType);
                    xNode.setResultType(resultType);
                    xNode.setSql(sql);
                    xNode.setParameter(parameter);
                    
                    map.put(namespace + "." + id, xNode);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return map;
    }

}
