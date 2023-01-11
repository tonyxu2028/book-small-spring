package cn.bugstack.middleware.mybatis.factory;

import cn.bugstack.middleware.mybatis.session.SqlSession;

/**
 * @description SqlSessionFactory 是开启Session数据库的工厂处理类。
 * @author naixixu
 * @date 2022/3/16
 */
public interface SqlSessionFactory {

    /**
     * 打开会话
     * @return      SqlSession
     */
    SqlSession openSession();

}
