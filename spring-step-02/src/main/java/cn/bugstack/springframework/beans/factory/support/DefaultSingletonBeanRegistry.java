package cn.bugstack.springframework.beans.factory.support;

import cn.bugstack.springframework.beans.factory.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * 容器单列对象注册器-接口实现类
 * 作者：DerekYRC <a href="https://github.com/DerekYRC/mini-spring">...</a>
 * @author naixixu
 * @date 2022/03/07
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    /**
     * 容器-已经创建的单例对象
     */
    private final Map<String, Object> singletonObjectMap = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjectMap.get(beanName);
    }

    @Override
    public void registerSingleton(String beanName, Object singletonObject) {
        singletonObjectMap.put(beanName, singletonObject);
    }

}
