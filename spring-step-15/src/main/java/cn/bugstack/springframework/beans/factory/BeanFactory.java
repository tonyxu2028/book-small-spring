package cn.bugstack.springframework.beans.factory;

import cn.bugstack.springframework.beans.BeansException;

/**
 * 博客：<a href="https://bugstack.cn">...</a> - 沉淀、分享、成长，让自己和他人都能有所收获！
 * 公众号：bugstack虫洞栈
 * Create by 小傅哥(fustack)
 * @author naixixu
 */
public interface BeanFactory {

    /**
     * 根据beanName从IOC容器中获取一个实例Bean
     * @param name                      beanName
     * @return                          bean实例
     * @throws BeansException           bean异常
     */
    Object getBean(String name) throws BeansException;

    /**
     * 根据beanName和clazz从IOC容器中获取一个实例Bean
     * @param name                      beanName
     * @param args                      构造函数参数
     * @return                          bean实例
     * @throws BeansException           bean异常
     */
    Object getBean(String name, Object... args) throws BeansException;

    /**
     * 根据beanName和clazz从IOC容器中获取一个实例Bean
     * @param name                      beanName
     * @param requiredType              bean类型
     * @return                          bean实例
     * @param <T>                       bean泛型
     * @throws BeansException           bean异常
     */
    <T> T getBean(String name, Class<T> requiredType) throws BeansException;

    /**
     * 根据clazz从IOC容器中获取一个实例Bean
     * @param requiredType              bean类型
     * @return                          bean实例
     * @param <T>                       bean泛型
     * @throws BeansException           bean异常
     */
    <T> T getBean(Class<T> requiredType) throws BeansException;
}
