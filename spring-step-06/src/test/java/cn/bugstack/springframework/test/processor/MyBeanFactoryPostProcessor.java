package cn.bugstack.springframework.test.processor;

import cn.bugstack.springframework.beans.exception.BeansException;
import cn.bugstack.springframework.beans.factory.config.PropertyValue;
import cn.bugstack.springframework.beans.factory.config.PropertyValues;
import cn.bugstack.springframework.beans.factory.beanfactory.ConfigurableListableBeanFactory;
import cn.bugstack.springframework.beans.factory.config.BeanDefinition;
import cn.bugstack.springframework.beans.factory.beanfactory.BeanFactoryPostProcessor;

/**
 * {@code @description} BeanFactoryPostProcessor 实例化 Bean 对象之前，修改 BeanDefinition 属性
 * 作者：DerekYRC <a href="https://github.com/DerekYRC/mini-spring">...</a>
 * @date 2022/03/10
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("company", " 从腾讯改为：字节跳动"));
    }

}
