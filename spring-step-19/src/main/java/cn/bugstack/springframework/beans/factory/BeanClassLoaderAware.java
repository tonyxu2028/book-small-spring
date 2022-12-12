package cn.bugstack.springframework.beans.factory;

/**
 *
 * @author naixixu
 * @description Callback that allows a bean to be aware of the bean
 * {@link ClassLoader class loader}; that is, the class loader used by the
 * present bean factory to load bean classes.
 * @date 2022/3/11
 *  /CodeDesignTutorials
 *
 */
public interface BeanClassLoaderAware extends Aware {

    /**
     * Set the {@link ClassLoader} to be used by this object.
     * @param classLoader           the owning {@code ClassLoader}
     */
    void setBeanClassLoader(ClassLoader classLoader);

}
