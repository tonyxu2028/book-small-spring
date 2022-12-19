package cn.bugstack.springframework.beans.factory;

/**
 * @description Callback that allows a bean to be aware of the bean
 * {@link ClassLoader class loader};
 * 作者：DerekYRC <a href="https://github.com/DerekYRC/mini-spring">...</a>
 * @author naixixu
 * @date 2022/3/11
 *
 */
public interface BeanClassLoaderAware extends Aware {

    /**
     * Set the {@code ClassLoader} to be used by this object.
     * @param classLoader        the owning ClassLoader (never {@code null}).
     */
    void setBeanClassLoader(ClassLoader classLoader);

}
