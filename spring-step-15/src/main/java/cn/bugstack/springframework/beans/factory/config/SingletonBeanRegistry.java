package cn.bugstack.springframework.beans.factory.config;

/**
 * 博客：<a href="https://bugstack.cn">...</a> - 沉淀、分享、成长，让自己和他人都能有所收获！
 * 公众号：bugstack虫洞栈
 * Create by 小傅哥(fustack)
 * <p>
 * 单例注册表
 * @author naixixu
 */
public interface SingletonBeanRegistry {

    /**
     * 注册单例对象
     * @param beanName                  bean名称
     * @return Object                   bean实例
     */
    Object getSingleton(String beanName);

    /**
     * 注册单例对象
     * @param beanName                  bean名称
     * @param singletonObject           bean实例
     */
    void registerSingleton(String beanName, Object singletonObject);

}
                                                