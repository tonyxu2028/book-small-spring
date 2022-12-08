package cn.bugstack.springframework.beans.factory.config;

import cn.bugstack.springframework.beans.BeansException;

/**
 *
 *
 *
 * 作者：DerekYRC <a href="https://github.com/DerekYRC/mini-spring">...</a>
 * @author naixixu
 * @description 用于修改新实例化 Bean 对象的扩展点
 * @date 2022/3/10
 *  /CodeDesignTutorials
 *
 */
public interface BeanPostProcessor {

    /**
     * 在 Bean 对象执行初始化方法之前，执行此方法
     *
     * @param bean                          Bean 对象
     * @param beanName                      Bean 对象名称
     * @return                              返回 Bean 对象
     * @throws BeansException               Bean异常
     */
    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;

    /**
     * 在 Bean 对象执行初始化方法之后，执行此方法
     *
     * @param bean                          Bean 对象
     * @param beanName                      Bean 对象名称
     * @return                              返回 Bean 对象
     * @throws BeansException               Bean异常
     */
    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;

}
