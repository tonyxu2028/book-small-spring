package cn.bugstack.springframework.beans.factory.support;

import cn.bugstack.springframework.beans.BeansException;
import cn.bugstack.springframework.core.io.Resource;
import cn.bugstack.springframework.core.io.ResourceLoader;

/**
 *
 *
 *
 * 作者：DerekYRC <a href="https://github.com/DerekYRC/mini-spring">...</a>
 * @author naixixu
 * @description Simple interface for bean definition readers.
 * @date 2022/3/9
 *
 *
 */
public interface BeanDefinitionReader {

    /**
     * 获取BeanDefinition注册表
     * @return BeanDefinitionRegistry
     */
    BeanDefinitionRegistry getRegistry();

    /**
     * 获取资源加载器
     * @return ResourceLoader           资源加载器
     */
    ResourceLoader getResourceLoader();

    /**
     * 加载BeanDefinition
     * @param resource                  需要加载的资源
     * @throws BeansException           bean异常
     */
    void loadBeanDefinitions(Resource resource) throws BeansException;

    /**
     * 加载BeanDefinition
     * @param resources                 需要加载的资源
     * @throws BeansException           bean异常
     */
    @SuppressWarnings("unused")
    void loadBeanDefinitions(Resource... resources) throws BeansException;

    /**
     * 加载BeanDefinition
     * @param location                  资源位置
     * @throws BeansException           bean异常
     */
    void loadBeanDefinitions(String location) throws BeansException;

    /**
     * 加载BeanDefinition
     * @param locations                 资源位置
     * @throws BeansException           bean异常
     */
    void loadBeanDefinitions(String... locations) throws BeansException;
}
