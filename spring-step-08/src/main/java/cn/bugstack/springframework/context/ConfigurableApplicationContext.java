package cn.bugstack.springframework.context;

import cn.bugstack.springframework.beans.BeansException;

/**
 *
 *
 *
 * 作者：DerekYRC <a href="https://github.com/DerekYRC/mini-spring">...</a>
 * @author naixixu
 * {@code @description} SPI 接口配置应用上下文 SPI interface to be implemented by most if not all application contexts.
 * Provides facilities to configure an application context in addition
 * to the application context client methods in the
 * {@link ApplicationContext} interface.
 * @date 2022/3/10
 *
 *
 */
public interface ConfigurableApplicationContext extends ApplicationContext {

    /**
     * 刷新容器
     *
     * @throws BeansException       bean异常
     */
    void refresh() throws BeansException;

    /**
     * 退出容器
     */
    void registerShutdownHook();

    /**
     * 关闭容器
     */
    void close();
}
