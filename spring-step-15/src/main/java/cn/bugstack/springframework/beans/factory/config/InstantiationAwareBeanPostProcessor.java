package cn.bugstack.springframework.beans.factory.config;

import cn.bugstack.springframework.beans.BeansException;
import cn.bugstack.springframework.beans.PropertyValues;

/**
 * Subinterface of {@link BeanPostProcessor} that adds a before-instantiation callback,
 * and a callback after instantiation but before explicit properties are set or
 * autowiring occurs.
 * <p>
 * 博客：<a href="https://bugstack.cn">...</a> - 沉淀、分享、成长，让自己和他人都能有所收获！
 * 公众号：bugstack虫洞栈
 * Create by 小傅哥(fustack)
 * @author naixixu
 */
public interface InstantiationAwareBeanPostProcessor extends BeanPostProcessor {

    /**
     * Apply this BeanPostProcessor <i>before the target bean gets instantiated</i>.
     * The returned bean object may be a proxy to use instead of the target bean,
     * effectively suppressing default instantiation of the target bean.
     * <p>
     * 在 Bean 对象执行初始化方法之前，执行此方法
     *
     * @param beanClass                     the raw class of the bean
     * @param beanName                      the name of the bean
     * @return                              the bean object to use instead of a default instance
     * @throws BeansException               in case of errors
     */
    Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException;

    /**
     * Perform operations after the bean has been instantiated, via a constructor or factory method,
     * but before Spring property population (from explicit properties or autowiring) occurs.
     * <p>This is the ideal callback for performing field injection on the given bean instance.
     * See Spring's own {@link cn.bugstack.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor}
     * for a typical example.
     * <p>
     * 在 Bean 对象执行初始化方法之后，执行此方法
     *
     * @param bean                          the new bean instance
     * @param beanName                      the name of the bean
     * @return                              the bean instance to use, either the original or a wrapped one;
     * @throws BeansException               in case of errors
     */
    boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException;

    /**
     * Post-process the given property values before the factory applies them
     * to the given bean. Allows for checking whether all dependencies have been
     * satisfied, for example based on a "Required" annotation on bean property setters.
     * <p>
     * 在 Bean 对象实例化完成后，设置属性操作之前执行此方法
     *
     * @param pvs                           the property values that the factory is about to apply
     * @param bean                          the bean instance created but whose properties have not yet been set
     * @param beanName                      the name of the bean
     * @return                              the property values to apply to the given bean
     * @throws BeansException               in case of errors
     */
    PropertyValues postProcessPropertyValues(PropertyValues pvs, Object bean, String beanName) throws BeansException;

}
