package cn.bugstack.springframework.beans.factory.beanfactory.impl;

import cn.bugstack.springframework.beans.factory.beanfactory.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * 作者：DerekYRC <a href="https://github.com/DerekYRC/mini-spring">...</a>
 * @author naixixu
 * {@code @description} 通用的注册表实现
 * @date 2022/03/07
 *
 *
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private final Map<String, Object> singletonObjects = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    @Override
    public void registerSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }

}
