package cn.bugstack.springframework.beans.factory.config;

import cn.bugstack.springframework.beans.BeansException;
import cn.bugstack.springframework.beans.PropertyValues;

/**
 *
 *
 *
 * 作者：DerekYRC <a href="https://github.com/DerekYRC/mini-spring">...</a>
 * @author naixixu
 * @description Subinterface of {@link BeanPostProcessor} that adds a before-instantiation callback,
 * and a callback after instantiation but before explicit properties are set or
 * autowiring occurs.
 * @date 2022/3/14
 *  /CodeDesignTutorials
 *
 */
public interface InstantiationAwareBeanPostProcessor extends BeanPostProcessor {

    /**
     * Apply this BeanPostProcessor <i>before the target bean gets instantiated</i>.
     * The returned bean object may be a proxy to use instead of the target bean,
     * effectively suppressing default instantiation of the target bean.
     * <p>
     * 在 Bean 对象执行初始化方法之前，执行此方法
     *
     * @param beanClass                 the raw class of the bean to be instantiated
     * @param beanName                  the name of the bean
     * @return                          the bean object to use instead of a default instance of the target bean,
     * @throws BeansException           in case of errors
     */
    Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException;

    /**
     * Post-process the given property values before the factory applies them
     * to the given bean. Allows for checking whether all dependencies have been
     * satisfied, for example based on a "Required" annotation on bean property setters.
     * <p>
     * 在 Bean 对象实例化完成后，设置属性操作之前执行此方法
     *
     * @param pvs                       the property values that the factory is about to apply (never {@code null})
     * @param bean                      the bean instance created but whose properties have not yet been set
     * @param beanName                  the name of the bean
     * @return                          the property values to apply to the given bean,
     * @throws BeansException           in case of errors
     */
    PropertyValues postProcessPropertyValues(PropertyValues pvs, Object bean, String beanName) throws BeansException;

}
