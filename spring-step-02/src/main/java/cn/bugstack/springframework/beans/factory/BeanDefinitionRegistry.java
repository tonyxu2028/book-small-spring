package cn.bugstack.springframework.beans.factory;

import cn.bugstack.springframework.beans.factory.config.BeanDefinition;

/**
 *
 *
 *
 * 作者：DerekYRC https://github.com/DerekYRC/mini-spring
 * @author naixixu
 * @description Bean 定义注册接口
 * @date 2022/03/07
 *
 *
 */
public interface BeanDefinitionRegistry {

    /**
     * 向BeanDefinition容器中注册 BeanDefinition
     *
     * @param beanName       Bean 名称
     * @param beanDefinition Bean 定义
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

}
