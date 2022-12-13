package cn.bugstack.springframework.beans.factory.support;

import cn.bugstack.springframework.beans.BeansException;
import cn.bugstack.springframework.core.io.Resource;
import cn.bugstack.springframework.core.io.ResourceLoader;

/**
 *
 * @author naixixu
 * @description Simple interface for bean definition readers.
 * @date 2022/3/9
 *
 *
 */
@SuppressWarnings("all")
public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeansException;

    /**
     * Load bean definitions from the specified resources.
     * @param resources                 资源
     * @throws BeansException           Bean 异常
     */
    @SuppressWarnings("unused")
    void loadBeanDefinitions(Resource... resources) throws BeansException;

    void loadBeanDefinitions(String location) throws BeansException;

    void loadBeanDefinitions(String... locations) throws BeansException;
}
