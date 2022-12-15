package cn.bugstack.springframework.beans.factory.beanfactory;

import cn.bugstack.springframework.beans.exception.BeansException;
import cn.bugstack.springframework.beans.factory.config.BeanDefinition;

/**
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
     * 获取BeanDefinition
     * @param beanName              bean名称
     * @return                      BeanDefinition
     * @throws BeansException       异常
     */
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * 注册BeanDefinition
     * @throws BeansException       异常
     */
    void preInstantiateSingletons() throws BeansException;

}
