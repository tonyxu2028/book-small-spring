package cn.bugstack.springframework.beans.factory.beanfactory;

import cn.bugstack.springframework.beans.exception.BeansException;

/**
 * {@code @description} BeanFactoryPostProcessor - Spring提供的扩展机制
 * 允许在Bean对象注册后，实例化Bean对象之前，修改BeanDefinition属性
 * 作者：DerekYRC <a href="https://github.com/DerekYRC/mini-spring">...</a>
 * @author naixixu
 * @date 2022/3/10
 */
public interface BeanFactoryPostProcessor {

    /**
     * 在所有的 BeanDefinition 加载完成后，实例化 Bean 对象之前，提供修改 BeanDefinition 属性的机制
     *
     * @param beanFactory           BeanFactory
     * @throws BeansException       异常
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;

}
