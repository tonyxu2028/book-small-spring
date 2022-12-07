package cn.bugstack.springframework.beans.factory;

import cn.bugstack.springframework.beans.BeansException;
import cn.bugstack.springframework.beans.factory.config.AutowireCapableBeanFactory;
import cn.bugstack.springframework.beans.factory.config.BeanDefinition;
import cn.bugstack.springframework.beans.factory.config.ConfigurableBeanFactory;

/**
 *
 *
 *
 * 作者：DerekYRC <a href="https://github.com/DerekYRC/mini-spring">...</a>
 * @author naixixu
 * {@code @description} Configuration interface to be implemented by most listable bean factories.
 * In addition to {@link ConfigurableBeanFactory}, it provides facilities to
 * analyze and modify bean definitions, and to pre-instantiate singletons.
 * @date 2022/3/9
 *  /CodeDesignTutorials
 *
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    /**
     * Return the bean definition for the given bean name.
     * @param beanName              name of the bean to find a definition for
     * @return                      the BeanDefinition for the given name (never {@code null})
     * @throws BeansException       if the bean definition cannot be resolved
     */
    @SuppressWarnings("unused")
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * Pre-instantiate singletons in this bean factory, respecting the {@link "allowCircularReferences"}
     *
     * @throws BeansException       if one of the singleton beans could not be created
     */
    void preInstantiateSingletons() throws BeansException;

}
