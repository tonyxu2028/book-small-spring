package cn.bugstack.springframework.mybatis;

import cn.bugstack.middleware.mybatis.factory.SqlSessionFactory;
import cn.bugstack.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @description 数据库操作映射工厂对象，每一个 DAO 接口对应 Mapper 的代理对象。通过代理对象完成数据库的操作。
 * @author naixixu
 * @date 2022/3/18
 */
public class MapperFactoryBean<T> implements FactoryBean<T> {

    private Class<T> mapperInterface;
    private SqlSessionFactory sqlSessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public T getObject() {
        InvocationHandler handler = (proxy, method, args) -> {
            // 排除 Object 方法；toString、hashCode
            if (Object.class.equals(method.getDeclaringClass())) {
                return method.invoke(this, args);
            }
            try {
                System.out.println("你被代理了，执行SQL操作！" + method.getName());
                return sqlSessionFactory.openSession().selectOne(mapperInterface.getName() + "." + method.getName(), args[0]);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return method.getReturnType().newInstance();
        };
        return (T) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{mapperInterface}, handler);
    }

    @Override
    public Class<?> getObjectType() {
        return mapperInterface;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @SuppressWarnings("unused")
    public void setMapperInterface(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    @SuppressWarnings("unused")
    public SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

    @SuppressWarnings("unused")
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @SuppressWarnings("unused")
    public MapperFactoryBean() {
    }

    @SuppressWarnings("unused")
    public MapperFactoryBean(Class<T> mapperInterface, SqlSessionFactory sqlSessionFactory) {
        this.mapperInterface = mapperInterface;
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @SuppressWarnings("unused")
    public Class<T> getMapperInterface() {
        return mapperInterface;
    }

}
