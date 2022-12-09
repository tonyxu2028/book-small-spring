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
     * Get the bean factory that this reader operates on.
     * @return                      the bean factory
     */
    BeanDefinitionRegistry getRegistry();

    /**
     * Get the resource loader to use for resource locations.
     * @return                      the resource loader
     */
    ResourceLoader getResourceLoader();

    /**
     * Load bean definitions from the specified resource.
     * @param resource              the resource descriptor
     * @throws BeansException       in case of loading or parsing errors
     */
    void loadBeanDefinitions(Resource resource) throws BeansException;

    /**
     * Load bean definitions from the specified resources.
     * @param resources             the resource descriptors
     * @throws BeansException       in case of loading or parsing errors
     */
    @SuppressWarnings("unused")
    void loadBeanDefinitions(Resource... resources) throws BeansException;

    /**
     * Load bean definitions from the specified resource location.
     * @param location              the resource location
     * @throws BeansException       in case of loading or parsing errors
     */
    void loadBeanDefinitions(String location) throws BeansException;

    /**
     * Load bean definitions from the specified resource locations.
     * @param locations             the resource locations
     * @throws BeansException       in case of loading or parsing errors
     */
    void loadBeanDefinitions(String... locations) throws BeansException;
}
