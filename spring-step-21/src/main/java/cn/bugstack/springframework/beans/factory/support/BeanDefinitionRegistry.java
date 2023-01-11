package cn.bugstack.springframework.beans.factory.support;

import cn.bugstack.springframework.beans.BeansException;
import cn.bugstack.springframework.beans.factory.config.BeanDefinition;

/**
 * @description Bean 定义注册接口 BeanDefinitionRegistry
 * @author naixixu
 * @date 2022/03/07
 */
public interface BeanDefinitionRegistry {

    /**
     * 向注册表中注册 BeanDefinition
     *
     * @param beanName              Bean 名称
     * @param beanDefinition        Bean 定义
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
    /**
     * 判断是否包含指定名称的BeanDefinition
     * @param beanName              Bean 名称
     * @return                      是否包含
     */
    boolean containsBeanDefinition(String beanName);

    /**
     * 使用Bean名称查询BeanDefinition
     *
     * @param beanName              Bean 名称
     * @return                      Bean 定义
     * @throws BeansException       Bean 异常
     */
    @SuppressWarnings("unused")
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;


    /**
     * Return the names of all beans defined in this registry.
     * <p>
     * @return 返回注册表中所有的Bean名称
     */
    @SuppressWarnings("unused")
    String[] getBeanDefinitionNames();

}
