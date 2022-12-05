package cn.bugstack.springframework;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author naixixu
 * {@code @description} 简单的 Bean 工厂实现
 * 作者：DerekYRC <a href="https://github.com/DerekYRC/mini-spring">...</a>
 * @date 2022/2/9
 *
 *
 */
public class BeanFactory {

    /**
     * 对象信息定义容器
     */
    private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    /**
     * 对象信息定义容器中注册对象信息
     *
     * @param name              对象名称
     * @param beanDefinition    对象信息定义
     */
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(name, beanDefinition);
    }

    /**
     * 根据对象名称从对象信息定义容器中获取对象信息
     *
     * @param name              对象名称
     * @return  Object
     */
    public Object getBean(String name) {
        return beanDefinitionMap.get(name).getBean();
    }

}
