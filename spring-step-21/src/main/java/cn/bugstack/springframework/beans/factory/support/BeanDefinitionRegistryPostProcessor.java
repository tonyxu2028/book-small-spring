package cn.bugstack.springframework.beans.factory.support;

import cn.bugstack.springframework.beans.BeansException;
import cn.bugstack.springframework.beans.factory.config.BeanFactoryPostProcessor;

/**
 * @description Extension to the standard {@link BeanFactoryPostProcessor}
 * @author naixixu
 * @date 2022/3/18
 */
public interface BeanDefinitionRegistryPostProcessor extends BeanFactoryPostProcessor {

    /**
     * Callback for custom initialization in a bean factory, after all bean definitions
     * @param registry              the bean definition registry used by the application context
     * @throws BeansException       in case of errors
     */
    void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException;

}
