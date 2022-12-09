package cn.bugstack.springframework.beans.factory.config;

import cn.bugstack.springframework.beans.BeansException;
import cn.bugstack.springframework.beans.factory.BeanFactory;

/**
 * Extension of the {@link cn.bugstack.springframework.beans.factory.BeanFactory}
 * interface to be implemented by bean factories that are capable of
 * autowiring, provided that they want to expose this functionality for
 * existing bean instances.
 * @author naixixu
 */
public interface AutowireCapableBeanFactory extends BeanFactory {

    /**
     * 执行 BeanPostProcessors 接口实现类的 postProcessBeforeInitialization 方法
     *
     * @param existingBean              Bean 对象
     * @param beanName                  Bean 对象名称
     * @return                          返回 Bean 对象
     * @throws BeansException           Bean 异常
     */
    Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException;

    /**
     * 执行 BeanPostProcessors 接口实现类的 postProcessorsAfterInitialization 方法
     *
     * @param existingBean              Bean 对象
     * @param beanName                  Bean 对象名称
     * @return                          返回 Bean 对象
     * @throws BeansException           Bean 异常
     */
    Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeansException;

}
