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
    public void init() {
        dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
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
            statement.execute("insert into user (id, userId, userHead, createTime, updateTime) " +
                    "values (1, '184172133','01_50', now(), now())");
            statement.execute("insert into user (id, userId, userHead, createTime, updateTime) " +
                    "values (1, '184172133','01_50', now(), now())");
        } catch (Exception e) {
            e.printStackTrace();
            connection.rollback();
        }

        connection.commit();
    }

}
