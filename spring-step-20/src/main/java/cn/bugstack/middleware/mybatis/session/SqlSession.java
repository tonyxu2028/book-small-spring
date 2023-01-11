package cn.bugstack.middleware.mybatis.session;

import java.util.List;

/**
 * @Description: SqlSession接口用于定义和处理对数据库的操作。
 * 这里定义了数据库操作的查询接口SqlSession,用于查询一个或者多个结果,同时包括有有参和无参的方法。
 * @author naixixu
 * @description SqlSession 接口
 * @date 2022/3/16
 *
 *
 */
public interface SqlSession {
    @SuppressWarnings("unused")
    <T> T selectOne(String statement);

    <T> T selectOne(String statement, Object parameter);

    @SuppressWarnings("unused")
    <T> List<T> selectList(String statement);

    <T> List<T> selectList(String statement, Object parameter);

    void close();
}
