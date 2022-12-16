package cn.bugstack.springframework.beans.factory.beanfactory;

/**
 * 作者：DerekYRC <a href="https://github.com/DerekYRC/mini-spring">...</a>
 * @author naixixu
 * {@code @description} Configuration interface to be implemented by most bean factories. Provides
 * facilities to configure a bean factory, in addition to the bean factory
 * client methods in the {@link BeanFactory}
 * interface.
 * @date 2022/3/9
 *
 *
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    @SuppressWarnings("unused")
    String SCOPE_SINGLETON = "singleton";

    @SuppressWarnings("unused")
    String SCOPE_PROTOTYPE = "prototype";

    /**
     * Set the parent of this bean factory.
     * @param beanPostProcessor the parent bean factory
     */
    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

}
