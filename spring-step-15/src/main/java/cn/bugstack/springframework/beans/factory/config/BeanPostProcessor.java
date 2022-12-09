package cn.bugstack.springframework.beans.factory.config;

import cn.bugstack.springframework.beans.BeansException;

/**
 * Factory hook that allows for custom modification of new bean instances,
 * e.g. checking for marker interfaces or wrapping them with proxies.
 * <p>
 * 用于修改新实例化 Bean 对象的扩展点
 * <p>
 * 博客：<a href="https://bugstack.cn">...</a> - 沉淀、分享、成长，让自己和他人都能有所收获！
 * 公众号：bugstack虫洞栈
 * Create by 小傅哥(fustack)
 * @author naixixu
 */
public interface BeanPostProcessor {

    /**
     * 在 Bean 对象执行初始化方法之前，执行此方法
     *
     * @param bean                      Bean 对象
     * @param beanName                  Bean 对象名称
     * @return                          返回 Bean 对象
     * @throws BeansException           Bean 异常
     */
    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;

    /**
     * 在 Bean 对象执行初始化方法之后，执行此方法
     *
     * @param bean                      Bean 对象
     * @param beanName                  Bean 对象名称
     * @return                          返回 Bean 对象
     * @throws BeansException           Bean 异常
     */
    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;

}
