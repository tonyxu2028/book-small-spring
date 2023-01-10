package cn.bugstack.springframework.test;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Before;

import com.mysql.cj.jdbc.Driver;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @description JDBC Test
 * @date 2022/3/18
 *  /CodeDesignTutorials
 *
 */
public class SpringStep19JdbcTest {

    private DruidDataSource dataSource;

    @Before
    public void init() throws SQLException {
        dataSource = new DruidDataSource();
        dataSource.setDriver(new Driver());
        dataSource.setUrl("jdbc:mysql://localhost:3307/spring?useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
    }

    @Test
    public void test_translation() throws SQLException {
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        connection.setAutoCommit(false);

        try {
            statement.execute("insert into user (userId, userHead, createTime, updateTime) " +
                    "values ('184172136','01_50', now(), now())");
            statement.execute("insert into user (userId, userHead, createTime, updateTime) " +
                    "values ('184172137','01_50', now(), now())");
        } catch (Exception e) {
            e.printStackTrace();
            connection.rollback();
        }

        connection.commit();
    }

}
