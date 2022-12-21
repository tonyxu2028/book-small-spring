package cn.bugstack.springframework.context.event;

import cn.bugstack.springframework.context.AbstractApplicationEvent;
import cn.bugstack.springframework.context.ApplicationListener;

/**
 * @description 接口是注册监听器和发布事件的广播器，提供添加，移除和发布事件的功能
 * 作者：DerekYRC <a href="https://github.com/DerekYRC/mini-spring">...</a>
 * @author naixixu
 * @date 2022/3/13
 */
public interface ApplicationEventMulticaster {

    // #######################Listener注册相关方法#######################

    /**
     * Add a listener to be notified of all events.
     * @param listener the listener to add
     */
    void addApplicationListener(ApplicationListener<?> listener);

    /**
     * Remove a listener from the notification list.
     * @param listener the listener to remove
     */
    @SuppressWarnings("unused")
    void removeApplicationListener(ApplicationListener<?> listener);



    // #######################Event事件广播相关方法#######################

    /**
     * Multicast the given application event to appropriate listeners.
     * @param event the event to multicast
     */
    void multicastEvent(AbstractApplicationEvent event);

}
