package cn.bugstack.springframework.beans.factory.beanfactory;

import cn.bugstack.springframework.beans.exception.BeansException;
import cn.bugstack.springframework.beans.factory.config.BeanDefinition;

/**
 * @Description: ConfigurableListableBeanFactory是一个提供分析和修改Bean对象与预先实例化的接口，
 * 不过目前只有getBeanDefinition方法，用于获取BeanDefinition对象。
 * 作者：DerekYRC <a href="https://github.com/DerekYRC/mini-spring">...</a>
 * @author naixixu
 * @date 2022/3/9
 */
@SuppressWarnings("unused")
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    /**
     * 获取 Bean 定义
     * @param beanName          Bean 名称
     * @return                  Bean 定义类
     * @throws BeansException   Bean 异常
     */
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

}
