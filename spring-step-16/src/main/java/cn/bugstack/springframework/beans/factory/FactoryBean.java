package cn.bugstack.springframework.beans.factory;

/**
 *
 *
 *
 * 作者：DerekYRC <a href="https://github.com/DerekYRC/mini-spring">...</a>
 * @author naixixu
 * @description Interface to be implemented by objects used within a {@link BeanFactory}
 * which are themselves factories. If a bean implements this interface,
 * it is used as a factory for an object to expose, not directly as a bean
 * instance that will be exposed itself.
 * @date 2022/3/11
 *  /CodeDesignTutorials
 *
 */
public interface FactoryBean<T> {

    /**
     * Return an instance (possibly shared or independent) of the object
     * @return                  bean 实例
     * @throws Exception        bean 异常
     */
    T getObject() throws Exception;

    /**
     * Return the type of object that this FactoryBean creates,
     * or {@code null} if not known in advance.
     * @return                  bean 类型
     */
    @SuppressWarnings("unused")
    Class<?> getObjectType();

    /**
     * Is the bean managed by this factory a singleton or a prototype?
     * That is, will {@link #getObject()} always return the same object?
     * @return                  是否单例
     */
    boolean isSingleton();

}