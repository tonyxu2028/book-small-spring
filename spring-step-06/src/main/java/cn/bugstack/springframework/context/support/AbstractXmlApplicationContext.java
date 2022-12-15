package cn.bugstack.springframework.context.support;

import cn.bugstack.springframework.beans.factory.beanfactory.impl.DefaultListableBeanFactory;
import cn.bugstack.springframework.beans.factory.read.impl.XmlBeanDefinitionReader;

/**
 *
 *
 *
 * 作者：DerekYRC <a href="https://github.com/DerekYRC/mini-spring">...</a>
 * @author naixixu
 * {@code @description} 抽象基类 XML 上下文 Convenient base class for {@link cn.bugstack.springframework.context.ApplicationContext}
 * implementations, drawing configuration from XML documents containing bean definitions
 * understood by an {@link XmlBeanDefinitionReader}.
 * @date 2022/3/10
 *
 *
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {

    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] configLocations = getConfigLocations();
        if (null != configLocations){
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }

    /**
     * 获取配置文件路径
     * @return              配置文件路径
     */
    protected abstract String[] getConfigLocations();

}
