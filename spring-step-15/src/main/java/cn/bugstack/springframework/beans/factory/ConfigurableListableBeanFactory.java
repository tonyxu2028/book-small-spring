package cn.bugstack.springframework.beans.factory;

import cn.bugstack.springframework.beans.BeansException;
import cn.bugstack.springframework.beans.factory.config.AutowireCapableBeanFactory;
import cn.bugstack.springframework.beans.factory.config.BeanDefinition;
import cn.bugstack.springframework.beans.factory.config.BeanPostProcessor;
import cn.bugstack.springframework.beans.factory.config.ConfigurableBeanFactory;

/**
 * Configuration interface to be implemented by most listable bean factories.
 * In addition to {@link ConfigurableBeanFactory}, it provides facilities to
 * analyze and modify bean definitions, and to pre-instantiate singletons.
 * <p>
 * 博客：<a href="https://bugstack.cn">...</a> - 沉淀、分享、成长，让自己和他人都能有所收获！
 * 公众号：bugstack虫洞栈
 * Create by 小傅哥(fustack)
 * @author naixixu
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    /**
     * Return the bean definition for the given bean name.
     * @param beanName                  name of the bean to find a definition for
     * @return                          the BeanDefinition for the given name (never {@code null})
     * @throws BeansException           if the bean could not be resolved
     */
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * Add a new BeanPostProcessor that will get applied to beans created
     * @throws BeansException           if the post processor cannot be initialized
     */
    void preInstantiateSingletons() throws BeansException;

    /**
     * Add a new BeanPostProcessor that will get applied to beans created
     * @param beanPostProcessor         the new BeanPostProcessor to add
     */
    @Override
    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

}
