package cn.bugstack.springframework.beans.factory;

import cn.bugstack.springframework.beans.BeansException;
import cn.bugstack.springframework.beans.factory.config.AutowireCapableBeanFactory;
import cn.bugstack.springframework.beans.factory.config.BeanDefinition;
import cn.bugstack.springframework.beans.factory.config.ConfigurableBeanFactory;

/**
 *
 * @author naixixu
 * @description Configuration interface to be implemented by most listable bean factories.
 * In addition to {@link ConfigurableBeanFactory}, it provides facilities to
 * analyze and modify bean definitions, and to pre-instantiate singletons.
 * @date 2022/3/9
 *  /CodeDesignTutorials
 *
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    /**
     * Return the bean definition for the given bean name.
     * @param beanName              the name of the bean to find a definition for
     * @return                      the BeanDefinition for the given name (never {@code null})
     * @throws BeansException       if the bean definition cannot be resolved
     */
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * Add a new BeanPostProcessor that will get applied to beans created
     * @throws BeansException       if the post processor cannot be initialized
     */
    void preInstantiateSingletons() throws BeansException;

}
