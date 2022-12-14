package cn.bugstack.springframework.beans.factory.strategy;

import cn.bugstack.springframework.beans.BeansException;
import cn.bugstack.springframework.beans.factory.InstantiationStrategy;
import cn.bugstack.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @description  简单实例化策略接口
 * @author naixixu
 * @date 2022/03/08
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy {

    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor<?> ctor, Object[] args)
            throws BeansException {
        Class<?> beanDefinitionBeanClass = beanDefinition.getBeanClass();
        try {
            if (null != ctor) { // 有参构造
                return beanDefinitionBeanClass.getDeclaredConstructor(ctor.getParameterTypes()).newInstance(args);
            } else {            // 无参构造
                return beanDefinitionBeanClass.getDeclaredConstructor().newInstance();
            }
        } catch (NoSuchMethodException | InstantiationException
                 | IllegalAccessException | InvocationTargetException e) {
            throw new BeansException("Failed to instantiate [" + beanDefinitionBeanClass.getName() + "]", e);
        }
    }

}
