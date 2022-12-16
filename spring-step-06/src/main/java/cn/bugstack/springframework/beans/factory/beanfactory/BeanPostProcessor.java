package cn.bugstack.springframework.beans.factory.beanfactory;

import cn.bugstack.springframework.beans.exception.BeansException;

/**
 * {@code @description} BeanPostProcessor - Spring提供的扩展机制
 * 允许在Bean对象执行初始化方法前后,对Bean对象进行修改，记录，替换等。
 * 这部分扩展功能与后面的AOP的实现有关系。
 * 作者：DerekYRC <a href="https://github.com/DerekYRC/mini-spring">...</a>
 * @author naixixu
 * @date 2022/3/10
 */
public interface BeanPostProcessor {

    /**
     * 在 Bean 对象执行初始化方法之前，执行此方法
     *
     * @param bean                  Bean 对象
     * @param beanName              Bean 对象名称
     * @return                      Bean 返回对象
     * @throws BeansException       Bean 异常
     */
    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;

    /**
     * 在 Bean 对象执行初始化方法之后，执行此方法
     *
     * @param bean                  Bean 对象
     * @param beanName              Bean 对象名称
     * @return                      Bean 返回对象
     * @throws BeansException       Bean 异常
     */
    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;

}
