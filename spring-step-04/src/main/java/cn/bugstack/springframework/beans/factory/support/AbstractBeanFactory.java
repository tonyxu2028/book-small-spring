package cn.bugstack.springframework.beans.factory.support;

import cn.bugstack.springframework.beans.BeansException;
import cn.bugstack.springframework.beans.factory.BeanFactory;
import cn.bugstack.springframework.beans.factory.config.BeanDefinition;

/**
 *
 *
 *
 * 作者：DerekYRC <a href="https://github.com/DerekYRC/mini-spring">...</a>
 * @author naixixu
 * {@code @description} 抽象的 Bean 工厂基类，定义模板方法
 * @date 2022/03/07
 *
 *
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String name) throws BeansException {
        return doGetBean(name, null);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return doGetBean(name, args);
    }

    protected Object doGetBean(final String name, final Object[] args) {
        Object bean = getSingleton(name);
        if (bean != null) {
            return bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name, beanDefinition, args);
    }

    /**
     * 获取 BeanDefinition
     * @param   beanName        beanName名称
     * @return  BeanDefinition  beanDefinition定义
     */
    protected abstract BeanDefinition getBeanDefinition(String beanName);

    /**
     * 创建 Bean
     * @param beanName          beanName名称
     * @param beanDefinition    beanDefinition定义
     * @param args              构造函数参数
     * @return                  bean实例
     */
    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args);

}
