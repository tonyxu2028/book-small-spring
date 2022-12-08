package cn.bugstack.springframework.beans.factory.support;

import cn.bugstack.springframework.beans.BeansException;
import cn.bugstack.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 *
 *
 *
 * 作者：DerekYRC <a href="https://github.com/DerekYRC/mini-spring">...</a>
 * @author naixixu
 * @description Bean 实例化策略接口
 * @date 2022/03/08
 *
 *
 */
public interface InstantiationStrategy {

    /**
     * 实例化 Bean
     * @param beanDefinition                    Bean 定义
     * @param beanName                          Bean 名称
     * @param ctor                              构造器
     * @param args                              构造器参数
     * @return                                  Bean 实例
     * @throws BeansException                   Bean 异常
     */
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor<?> ctor, Object[] args) throws BeansException;

}
