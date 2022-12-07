package cn.bugstack.springframework.beans.factory.support;

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
@SuppressWarnings("unused")
public interface BeanDefinitionReader {

    /**
     * 获取Bean定义注册表
     * @return                      Bean定义注册表
     */
    BeanDefinitionRegistry getRegistry();

    /**
     * 获取资源加载器
     * @return                      资源加载器
     */
    ResourceLoader getResourceLoader();

    /**
     * 加载Bean定义
     * @param resource              资源位置
     * @throws BeansException       bean异常
     */
    void loadBeanDefinitions(Resource resource) throws BeansException;

    /**
     * 加载Bean定义
     * @param resources             资源集合
     * @throws BeansException       bean异常
     */
    void loadBeanDefinitions(Resource... resources) throws BeansException;

    /**
     * 加载Bean定义
     * @param location              资源位置
     * @throws BeansException       bean异常
     */
    void loadBeanDefinitions(String location) throws BeansException;

    /**
     * 加载Bean定义
     * @param locations             资源位置集合
     * @throws BeansException       bean异常
     */
    void loadBeanDefinitions(String... locations) throws BeansException;
}
