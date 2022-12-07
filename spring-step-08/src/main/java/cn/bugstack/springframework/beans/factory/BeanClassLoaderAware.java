package cn.bugstack.springframework.beans.factory;

/**
 *
 *
 *
 * 作者：DerekYRC https://github.com/DerekYRC/mini-spring
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
     * Set the {@code ClassLoader} to be used by this object.
     * @param classLoader        the owning ClassLoader (never {@code null}).
     */
    void setBeanClassLoader(ClassLoader classLoader);

}
