package cn.bugstack.springframework.context.support;

import cn.bugstack.springframework.beans.exception.BeansException;
import cn.bugstack.springframework.beans.factory.beanfactory.ConfigurableListableBeanFactory;
import cn.bugstack.springframework.beans.factory.beanfactory.impl.DefaultListableBeanFactory;

/**
 * {@code @description} 抽象基类刷新应用上下文 Base class for
 * {@link cn.bugstack.springframework.context.ApplicationContext}
 * 作者：DerekYRC <a href="https://github.com/DerekYRC/mini-spring">...</a>
 * @author naixixu
 * @date 2022/3/10
 *
 *
 */
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext {

    private DefaultListableBeanFactory beanFactory;

    @Override
    protected ConfigurableListableBeanFactory getBeanFactory() {
        return beanFactory;
    }

    @Override
    protected void refreshBeanFactory() throws BeansException {
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;
    }

    private DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }

    /**
     * 加载BeanDefinition
     * @param beanFactory   beanFactory
     */
    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);

}
