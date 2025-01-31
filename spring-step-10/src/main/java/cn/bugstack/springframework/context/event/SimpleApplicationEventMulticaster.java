package cn.bugstack.springframework.context.event;

import cn.bugstack.springframework.beans.factory.BeanFactory;
import cn.bugstack.springframework.context.AbstractApplicationEvent;
import cn.bugstack.springframework.context.ApplicationListener;

/**
 *
 *
 *
 * 作者：DerekYRC <a href="https://github.com/DerekYRC/mini-spring">...</a>
 * @author naixixu
 * @description Simple implementation of the {@link ApplicationEventMulticaster} interface.
 * @date 2022/3/13
 *  /CodeDesignTutorials
 *
 */
public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster {

    public SimpleApplicationEventMulticaster(BeanFactory beanFactory) {
        setBeanFactory(beanFactory);
    }

    @Override
    public void multicastEvent(final AbstractApplicationEvent event) {
        for (final ApplicationListener listener : getApplicationListeners(event)) {
            listener.onApplicationEvent(event);
        }
    }

}
