package cn.bugstack.springframework.beans.factory.beanfactory;

import cn.bugstack.springframework.beans.exception.BeansException;
import cn.bugstack.springframework.beans.factory.config.BeanDefinition;

/**
 *
 *
 *
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

    /**
     * 根据 Bean 名称获取 Bean 定义
     * @param beanName          Bean 名称
     * @return                  Bean 定义
     * @throws BeansException   Bean 异常
     */
    @SuppressWarnings("unused")
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * 判断是否包含指定名称的BeanDefinition
     * @param beanName          Bean 名称
     * @return                  是否包含
     */
    boolean containsBeanDefinition(String beanName);

    /**
     * 返回注册表中所有BeanDefinition的名称
     * @return  BeanDefinition的名称数组
     */
    @SuppressWarnings("unused")
    String[] getBeanDefinitionNames();

}
