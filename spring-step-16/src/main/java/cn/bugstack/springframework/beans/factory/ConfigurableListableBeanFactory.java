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
 * @description Configuration interface to be implemented by most listable bean factories.
 * In addition to {@link ConfigurableBeanFactory}, it provides facilities to
 * analyze and modify bean definitions, and to pre-instantiate singletons.
 * @date 2022/3/9
 *  /CodeDesignTutorials
 *
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    /**
     * Add a new BeanPostProcessor that will get applied to beans created
     * @param beanName                  the name of the bean
     * @return                          the merged BeanDefinition for the given bean
     * @throws BeansException           if the initialization of the post processor failed
     */
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * Add a new BeanPostProcessor that will get applied to beans created
     * @throws BeansException           if the initialization of the post processor failed
     */
    void preInstantiateSingletons() throws BeansException;

}
