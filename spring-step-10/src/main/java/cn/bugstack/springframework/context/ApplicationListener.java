package cn.bugstack.springframework.context;

import java.util.EventListener;

/**
 * @description 定义和实现事件
 * 作者：DerekYRC <a href="https://github.com/DerekYRC/mini-spring">...</a>
 * @author naixixu
 * @date 2022/3/13
 */
public interface ApplicationListener<E extends AbstractApplicationEvent> extends EventListener {

    /**
     * Handle an application event.
     * @param event the event to respond to
     */
    void onApplicationEvent(E event);

}