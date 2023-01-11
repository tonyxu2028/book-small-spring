package cn.bugstack.middleware.mybatis;

import java.util.List;

/**
 *
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
