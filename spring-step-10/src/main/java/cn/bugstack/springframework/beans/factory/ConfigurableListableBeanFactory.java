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
     * Return the bean definition for the given bean name.
     * @param beanName              bean名称
     * @return                      BeanDefinition
     * @throws BeansException       bean异常
     */
    @SuppressWarnings("unused")
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * Pre-instantiate singletons in this factory, respecting the current
     * @throws BeansException       bean异常
     */
    void preInstantiateSingletons() throws BeansException;

}
