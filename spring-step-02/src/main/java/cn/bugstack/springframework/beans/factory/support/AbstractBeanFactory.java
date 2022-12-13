package cn.bugstack.springframework.beans.factory.support;

import cn.bugstack.springframework.beans.BeansException;
import cn.bugstack.springframework.beans.factory.BeanFactory;
import cn.bugstack.springframework.beans.factory.config.BeanDefinition;

/**
 * @description 抽象的Bean工厂基类，实现了容器实例工厂获取器接口的getBean方法，并定义模板方法
 * 作者：DerekYRC <a href="https://github.com/DerekYRC/mini-spring">...</a>
 * @author naixixu
 * @date 2022/03/07
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    /**
     * 定义Bean工厂接口的实现
     * @param                           name 要检索的bean的名称
     * @return                          实例化的 Bean 对象
     * @throws BeansException           如果bean实例化失败,抛出异常
     *
     * 一个值得注意的点，作者在getBeanDefinition方法中，直接抛出了自定义异常BeansException。
     */
    @Override
    public Object getBean(String name) throws BeansException {
        // 从当前的容器中获取
        Object bean = getSingleton(name);
        if (bean != null) {
            return bean;
        }
        // 在当前的容器中没有的情况下，创建一个新的Bean
        BeanDefinition beanDefinition = getBeanDefinition(name); // 获取 BeanDefinition，然后进行bean的实例化创建
        return createBean(name,beanDefinition);
    }

    /**
     * 获取 BeanDefinition
     * @param beanName                  bean的名称
     * @return                          BeanDefinition
     */
    protected abstract BeanDefinition getBeanDefinition(String beanName);

    /**
     * 创建 Bean
     * @param beanName                  bean名称
     * @param beanDefinition            bean定义
     * @return                          实例化的Bean对象
     */
    protected abstract Object createBean(String beanName,BeanDefinition beanDefinition);

}
