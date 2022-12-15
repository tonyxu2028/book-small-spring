package cn.bugstack.springframework.beans.factory.beanfactory;

import cn.bugstack.springframework.beans.exception.BeansException;
import cn.bugstack.springframework.beans.factory.config.BeanDefinition;

/**
 * 作者：DerekYRC <a href="https://github.com/DerekYRC/mini-spring">...</a>
 * @author naixixu
 * {@code @description} Bean 定义注册接口
 * @date 2022/03/07
 *
 *
 */
@SuppressWarnings("unused")
public interface BeanDefinitionRegistry {

    /**
     * 向注册表中注册 BeanDefinition
     *
     * @param beanName          Bean 名称
     * @param beanDefinition    Bean 定义
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    /**
     * 使用Bean名称查询BeanDefinition
     *
     * @param beanName          Bean 名称
     * @return                  BeanDefinition
     * @throws BeansException   Bean异常
     */
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * 判断是否包含指定名称的BeanDefinition
     * @param beanName          Bean 名称
     * @return                  是否包含
     */
    boolean containsBeanDefinition(String beanName);

   /**
     * 获取所有注册的BeanDefinition名称
     * @return                  BeanDefinition名称数组
     */
    String[] getBeanDefinitionNames();

}
