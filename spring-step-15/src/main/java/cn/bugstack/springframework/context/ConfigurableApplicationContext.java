package cn.bugstack.springframework.context;

import cn.bugstack.springframework.beans.BeansException;

/**
 * SPI interface to be implemented by most if not all application contexts.
 * Provides facilities to configure an application context in addition
 * to the application context client methods in the
 * {@link ApplicationContext} interface.
 * <p>
 * 博客：<a href="https://bugstack.cn">...</a> - 沉淀、分享、成长，让自己和他人都能有所收获！
 * 公众号：bugstack虫洞栈
 * Create by 小傅哥(fustack)
 * @author naixixu
 */
public interface ConfigurableApplicationContext extends ApplicationContext {

    /**
     * 刷新容器
     *
     * @throws BeansException                   bean异常
     */
    void refresh() throws BeansException;

    /**
     * 注册关闭容器的钩子
     */
    @SuppressWarnings("unused")
    void registerShutdownHook();

    /**
     * 关闭容器
     */
    void close();

}
