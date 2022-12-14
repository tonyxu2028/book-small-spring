package cn.bugstack.springframework.beans.factory;

import cn.bugstack.springframework.beans.BeansException;
import cn.bugstack.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @description  实例化策略接口
 * 1) 构造函数的实例化策略
 * @author naixixu
 * @date 2022/03/08
 */
public interface InstantiationStrategy {

    /**
     * 实例化 Bean接口
     * @param beanDefinition        Bean 定义
     * @param beanName              Bean 名称
     * @param constructor           Bean 构造函数
     * @param args                  Bean 构造函数参数
     * @return                      Bean 实例
     * @throws BeansException       Bean 异常
     */
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor<?> constructor, Object[] args) throws BeansException;

}
