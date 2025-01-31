package cn.bugstack.springframework.beans.factory;

/**
 * @description 容器单列对象注册器-接口
 * 主要用于定义一个注册和获取单列对象的接口
 * @author naixixu
 * @date 2022/03/07
 */
public interface SingletonBeanRegistry {

    /**
     * 返回在给定名称下注册的（原始）单例对象。
     * @param beanName 要查找的bean的名称
     * @return 返回注册的单例对象
     */
    Object getSingleton(String beanName);

    /**
     * 注册单利对象
     * @param beanName          Bean 对象名称
     * @param singletonObject   Bean 对象
     */
    void registerSingleton(String beanName, Object singletonObject);

}
