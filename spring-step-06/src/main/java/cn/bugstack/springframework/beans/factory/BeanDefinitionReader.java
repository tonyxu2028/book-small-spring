package cn.bugstack.springframework.beans.factory;

import cn.bugstack.springframework.beans.BeansException;
import cn.bugstack.springframework.core.io.Resource;
import cn.bugstack.springframework.core.io.ResourceLoader;

/**
 * 作者：DerekYRC <a href="https://github.com/DerekYRC/mini-spring">...</a>
 * @author naixixu
 * {@code @description} Simple interface for bean definition readers.
 * @date 2022/3/9
 *
 *
 */
public interface BeanDefinitionReader {

    /**
     * 获取BeanDefinition注册器
     * @return                      BeanDefinition注册器
     */
    BeanDefinitionRegistry getRegistry();

    /**
     * 获取资源加载器
     * @return                      资源加载器
     */
    ResourceLoader getResourceLoader();

    /**
     * 加载BeanDefinition
     * @param resource              资源位置
     * @throws BeansException       Bean异常
     */
    void loadBeanDefinitions(Resource resource) throws BeansException;

    /**
     * 加载BeanDefinition
     * @param resources             资源位置
     * @throws BeansException       Bean异常
     */
    @SuppressWarnings("unused")
    void loadBeanDefinitions(Resource... resources) throws BeansException;

    /**
     * 加载BeanDefinition
     * @param location              资源位置
     * @throws BeansException       Bean异常
     */
    void loadBeanDefinitions(String location) throws BeansException;

    /**
     * 加载BeanDefinitions
     * @param locations             资源位置
     * @throws BeansException       Bean异常
     */
    void loadBeanDefinitions(String... locations) throws BeansException;
}
