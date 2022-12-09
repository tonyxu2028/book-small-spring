package cn.bugstack.springframework.beans.factory.support;

import cn.bugstack.springframework.beans.BeansException;
import cn.bugstack.springframework.core.io.Resource;
import cn.bugstack.springframework.core.io.ResourceLoader;

/**
 * Simple interface for bean definition readers.
 *
 * 博客：<a href="https://bugstack.cn">...</a> - 沉淀、分享、成长，让自己和他人都能有所收获！
 * 公众号：bugstack虫洞栈
 * Create by 小傅哥(fustack)
 * @author naixixu
 */
public interface BeanDefinitionReader {

    /**
     * Load bean definitions from the specified resource.
     * @return                  the number of bean definitions found
     */
    BeanDefinitionRegistry getRegistry();

    /**
     * Return the ResourceLoader that this bean definition reader
     * works with.
     * @return                  the ResourceLoader (never <code>null</code>)
     */
    ResourceLoader getResourceLoader();

    /**
     * Load bean definitions from the specified resource.
     * @param resource          the resource descriptor
     * @throws BeansException   in case of loading or parsing errors
     */

    void loadBeanDefinitions(Resource resource) throws BeansException;

    /**
     * Load bean definitions from the specified resources.
     * @param resources         the resource descriptors
     * @throws BeansException   in case of loading or parsing errors
     */
    @SuppressWarnings("unused")
    void loadBeanDefinitions(Resource... resources) throws BeansException;

    /**
     * Load bean definitions from the specified resource locations.
     * @param location          the resource location
     * @throws BeansException   in case of loading or parsing errors
     */
    void loadBeanDefinitions(String location) throws BeansException;

    /**
     * Load bean definitions from the specified resource locations.
     * @param locations         the resource locations
     * @throws BeansException   in case of loading or parsing errors
     */
    void loadBeanDefinitions(String... locations) throws BeansException;

}
