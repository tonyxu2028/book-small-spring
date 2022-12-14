package cn.bugstack.springframework.beans.factory.support;

import cn.bugstack.springframework.beans.BeansException;
import cn.bugstack.springframework.beans.factory.BeanDefinitionRegistry;
import cn.bugstack.springframework.beans.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

/**
 * @description DefaultListableBeanFactory
 * 1）实现了BeanDefinitionRegistry实例定义注册器-接口。
 * 2）实现了继承的AbstractAutowireCapableBeanFactory尚未实现的getBeanDefinition方法。
 * @author naixixu
 * @date 2022/03/07
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry {

    private final static String NO_BEAN_NAMED = "No bean named '";

    private final static String IS_DEFINED = "' is defined";

    /**
     * 容器-Bean定义信息
     */
    private final Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    /**
     *
     * {@code @description} 通过beanName获取BeanDefinition
     * @param   beanName        bean名称
     * @return  BeanDefinition  bean定义信息
     */
    @Override
    protected BeanDefinition getBeanDefinition(String beanName) {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null) {
            throw new BeansException(NO_BEAN_NAMED + beanName + IS_DEFINED);
        }
        return beanDefinition;
    }

    /**
     * 向BeanDefinition容器中注册 BeanDefinition
     * @param beanName       Bean 名称
     * @param beanDefinition Bean 定义
     */
    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }

}
