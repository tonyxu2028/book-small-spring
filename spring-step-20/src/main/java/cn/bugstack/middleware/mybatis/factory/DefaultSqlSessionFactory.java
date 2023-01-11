package cn.bugstack.middleware.mybatis.factory;

import cn.bugstack.middleware.mybatis.beans.Configuration;
import cn.bugstack.middleware.mybatis.session.DefaultSqlSession;
import cn.bugstack.middleware.mybatis.session.SqlSession;

/**
 *
 * @author naixixu
 * @description DefaultSqlSessionFactory
 * @date 2022/3/16
 *
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private final Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(configuration.connection, configuration.mapperElement);
    }

}
