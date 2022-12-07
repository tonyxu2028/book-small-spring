package cn.bugstack.springframework.context;

import java.util.EventListener;

/**
 *
 *
 *
 * 作者：DerekYRC https://github.com/DerekYRC/mini-spring
 * @description Interface to be implemented by application event listeners.
 * Based on the standard <code>java.util.EventListener</code> interface
 * for the Observer design pattern.
 * @date 2022/3/13
 *  /CodeDesignTutorials
 *
 */
public interface ApplicationListener<E extends AbstractApplicationEvent> extends EventListener {

    /**
     * Handle an application event.
     * @param event the event to respond to
     */
    void onApplicationEvent(E event);

}