package cn.bugstack.middleware.mybatis.beans;

import java.sql.Connection;
import java.util.Map;

/**
 *
 * @author naixixu
 * @description 链接信息和数据源配置类
 * @date 2022/3/16
 *  /CodeDesignTutorials
 *
 */
public class Configuration {

    public Connection connection;
    public Map<String, String> dataSource;
    public Map<String, XNode> mapperElement;

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public void setDataSource(Map<String, String> dataSource) {
        this.dataSource = dataSource;
    }

    public void setMapperElement(Map<String, XNode> mapperElement) {
        this.mapperElement = mapperElement;
    }

}
