package cn.bugstack.springframework.beans.factory;

/**
 * Interface to be implemented by objects used within a {@link BeanFactory}
 * which are themselves factories. If a bean implements this interface,
 * it is used as a factory for an object to expose, not directly as a bean
 * instance that will be exposed itself.
 * @author naixixu
 * @param <T>
 *
 * 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 * 公众号：bugstack虫洞栈
 * Create by 小傅哥(fustack)
 */
public interface FactoryBean<T> {

    /**
     * Return an instance (possibly shared or independent) of the object
     * @return                  an instance of the bean
     * @throws Exception        in case of creation errors
     */
    T getObject() throws Exception;

    /**
     * Return the type of object that this FactoryBean creates,
     * @return                  the type of object that this FactoryBean creates,
     */
    @SuppressWarnings("unused")
    Class<?> getObjectType();

    /**
     * Is the bean managed by the factory a singleton or a prototype?
     * @return                  true if the bean is a singleton
     */
    boolean isSingleton();

}
