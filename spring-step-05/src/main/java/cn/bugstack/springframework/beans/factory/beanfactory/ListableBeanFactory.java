package cn.bugstack.springframework.beans.factory.beanfactory;

import cn.bugstack.springframework.beans.exception.BeansException;

import java.util.Map;

/**
 * @description ListableBeanFactory接口继承了BeanFactory接口，它是一个扩展接口，它新增了部分方法。
 * 1）一个方法getBeansOfType，用于获取指定类型的所有bean实例
 * 2）一个方法getBeanDefinitionNames，用于获取所有bean定义的名称
 * 作者：DerekYRC <a href="https://github.com/DerekYRC/mini-spring">...</a>
 * @author naixixu
 * @date 2022/3/9
 */
@SuppressWarnings("unused")
public interface ListableBeanFactory extends BeanFactory{

    /**
     * 按照类型返回 Bean 实例
     * @param type              Bean 类型
     * @param <T>               Bean 类型
     * @return                  Bean 实例
     * @throws BeansException   Bean 异常
     */
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

    /**
     * 返回容器中所有的 Bean 的名称
     * @return                  Bean 名称数组
     */
    String[] getBeanDefinitionNames();

}
