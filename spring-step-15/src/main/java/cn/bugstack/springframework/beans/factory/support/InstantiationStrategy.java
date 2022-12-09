package cn.bugstack.springframework.beans.factory.support;

import cn.bugstack.springframework.beans.BeansException;
import cn.bugstack.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * 博客：<a href="https://bugstack.cn">...</a> - 沉淀、分享、成长，让自己和他人都能有所收获！
 * 公众号：bugstack虫洞栈
 * Create by 小傅哥(fustack)
 * <p>
 * Bean 实例化策略
 * @author naixixu
 */
public interface InstantiationStrategy {

    /**
     * 实例化 Bean
     * @param beanDefinition            Bean 定义
     * @param beanName                  Bean 名称
     * @param ctor                      构造器
     * @param args                      构造器参数
     * @return                          Bean 实例
     * @throws BeansException           Bean 异常
     */
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor<?> ctor, Object[] args) throws BeansException;

}
