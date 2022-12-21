package cn.bugstack.springframework.beans.factory;

/**
 * @description Interface to be implemented by objects used within a
 * 作者：DerekYRC <a href="https://github.com/DerekYRC/mini-spring">...</a>
 * @author naixixu
 * {@link BeanFactory}
 * @date 2022/3/11
 *  /CodeDesignTutorials
 *
 */
public interface FactoryBean<T> {

    /**
     * Return an instance (possibly shared or independent) of the object
     * @return                          an instance of the bean
     * @throws Exception                in case of creation errors.
     */
    T getObject() throws Exception;

    /**
     * Return the type of object that this FactoryBean creates, or null if not known in advance.
     * @return                          the type of object that this FactoryBean creates, or null if not known in advance
     */
    @SuppressWarnings("unused")
    Class<?> getObjectType();

    /**
     * Is the bean managed by this factory a singleton or a prototype?
     * @return                          true if this bean is a singleton
     */
    boolean isSingleton();

}