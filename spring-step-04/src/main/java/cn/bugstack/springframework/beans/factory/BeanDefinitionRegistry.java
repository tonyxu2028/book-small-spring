package cn.bugstack.springframework.beans.factory;

import cn.bugstack.springframework.beans.factory.config.BeanDefinition;

/**
 * 作者：DerekYRC <a href="https://github.com/DerekYRC/mini-spring">...</a>
 * @author naixixu
 * {@code @description} Bean 定义注册接口
 * @date 2022/03/07
 *
 *
 */
public interface BeanDefinitionRegistry {

    /**
     * 向注册表中注册 BeanDefinition
     *
     * @param beanName       Bean 名称
     * @param beanDefinition Bean 定义
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

}
