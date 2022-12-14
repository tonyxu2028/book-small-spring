package cn.bugstack.springframework.beans.factory.support;

import cn.bugstack.springframework.beans.BeansException;
import cn.bugstack.springframework.beans.factory.config.BeanDefinition;

/**
 * @description AbstractAutowireCapableBeanFactory
 * 1）抽象的容器实例工厂获取器-接口BeanFactory基类AbstractBeanFactory的抽象实现类。
 * 2）主要实现AbstractBeanFactory尚未实现的createBean方法。
 * @author naixixu
 * @date 2022/03/07
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{

    @Override
    protected Object createBean(String beanName,BeanDefinition beanDefinition) throws BeansException {
        try {
            Object bean = beanDefinition.getBeanClass().newInstance();
            registerSingleton(beanName, bean);
            return bean;
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
    }

}
