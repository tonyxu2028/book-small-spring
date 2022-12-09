package cn.bugstack.springframework.context.event;

import cn.bugstack.springframework.context.ApplicationContext;
import cn.bugstack.springframework.context.ApplicationEvent;

/**
 * Base class for events raised for an <code>ApplicationContext</code>.
 * <p>
 * 博客：<a href="https://bugstack.cn">...</a> - 沉淀、分享、成长，让自己和他人都能有所收获！
 * 公众号：bugstack虫洞栈
 * Create by 小傅哥(fustack)
 * @author naixixu
 */
public class ApplicationContextEvent extends ApplicationEvent {

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationContextEvent(Object source) {
        super(source);
    }

    /**
     * Get the <code>ApplicationContext</code> that the event was raised for.
     */
    @SuppressWarnings("unused")
    public final ApplicationContext getApplicationContext() {
        return (ApplicationContext) getSource();
    }

}
