package cn.bugstack.springframework.beans.factory.support;

import cn.bugstack.springframework.beans.BeansException;
import cn.bugstack.springframework.beans.factory.BeanFactory;
import cn.bugstack.springframework.beans.factory.config.BeanDefinition;

/**
 * 作者：DerekYRC https://github.com/DerekYRC/mini-spring
 * @author naixixu
 * @description 抽象的 Bean 工厂基类，定义模板方法
 * @date 2022/03/07
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    /**
     * 定义Bean工厂接口的实现
     * @param       name 要检索的bean的名称
     * @return      实例化的 Bean 对象
     * @throws      BeansException
     */
    @Override
    public Object getBean(String name) throws BeansException {
        // 从当前的容器中获取
        Object bean = getSingleton(name);
        if (bean != null) {
            return bean;
        }
        // 在当前的容器中没有的情况下，获取 BeanDefinition，然后进行bean的实例化创建
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name, beanDefinition);
    }

    /**
     * 获取 BeanDefinition
     * @param beanName
     * @return
     */
    protected abstract BeanDefinition getBeanDefinition(String beanName);

    /**
     * 创建 Bean
     * @param beanName
     * @param beanDefinition
     * @return
     */
    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition);

}
