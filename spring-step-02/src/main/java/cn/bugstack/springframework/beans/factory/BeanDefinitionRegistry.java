package cn.bugstack.springframework.beans.factory;

import cn.bugstack.springframework.beans.factory.config.BeanDefinition;

/**
 * @description 实例定义注册器-接口
 * @author naixixu
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
