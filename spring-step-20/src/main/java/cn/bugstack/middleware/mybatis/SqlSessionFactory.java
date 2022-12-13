package cn.bugstack.middleware.mybatis;

/**
 *
 * @author naixixu
 * @description SqlSessionFactory
 * @date 2022/3/16
 *
 *
 */
public interface SqlSessionFactory {

    /**
     * 打开会话
     * @return      SqlSession
     */
    SqlSession openSession();

}
