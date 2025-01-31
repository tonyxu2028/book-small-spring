package cn.bugstack.middleware.mybatis.test;

import cn.bugstack.middleware.mybatis.factory.Resources;
import cn.bugstack.middleware.mybatis.session.SqlSession;
import cn.bugstack.middleware.mybatis.factory.SqlSessionFactory;
import cn.bugstack.middleware.mybatis.factory.SqlSessionFactoryBuilder;
import cn.bugstack.middleware.mybatis.test.po.User;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.io.Reader;
import java.util.List;

public class SpringStep20Test {

    @Test
    public void test_queryUserInfoById() {
        String resource = "mybatis-config-datasource.xml";
        Reader reader;
        try {
            reader = Resources.getResourceAsReader(resource);
            SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
            SqlSession session = sqlMapper.openSession();
            try {
                User user = session.selectOne(
                        "cn.bugstack.middleware.mybatis.test.dao.IUserDao.queryUserInfoById", 1);
                if(user!=null) {
                    System.out.println(JSON.toJSONString(user));
                }
            } finally {
                session.close();
                reader.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test_queryUserList() {
        String resource = "mybatis-config-datasource.xml";
        Reader reader;
        try {
            reader = Resources.getResourceAsReader(resource);
            SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);

            SqlSession session = sqlMapper.openSession();
            try {
                User req = new User();
                req.setUserId("184172133");
                List<User> userList = session.selectList(
                        "cn.bugstack.middleware.mybatis.test.dao.IUserDao.queryUserList", req);
                System.out.println(JSON.toJSONString(userList));
            } finally {
                session.close();
                reader.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
