package cn.bugstack.springframework.context.event;

import cn.bugstack.springframework.beans.BeansException;
import cn.bugstack.springframework.beans.factory.BeanFactory;
import cn.bugstack.springframework.beans.factory.BeanFactoryAware;
import cn.bugstack.springframework.context.AbstractApplicationEvent;
import cn.bugstack.springframework.context.ApplicationListener;
import cn.bugstack.springframework.util.ClassUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @description Abstract implementation of the
 * {@link ApplicationEventMulticaster} interface,
 * 作者：DerekYRC <a href="https://github.com/DerekYRC/mini-spring">...</a>
 * @author naixixu
 * @date 2022/3/13
 */
public abstract class AbstractApplicationEventMulticaster implements
        ApplicationEventMulticaster<AbstractApplicationEvent>, BeanFactoryAware {

    private BeanFactory beanFactory;

    public final Set<ApplicationListener<AbstractApplicationEvent>> applicationListeners = new LinkedHashSet<>();

    @Override
    public final void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    @SuppressWarnings("unused")
    public BeanFactory getBeanFactory() {
        return beanFactory;
    }



    // #######################Listener注册相关方法#######################

    @Override
    public void addApplicationListener(ApplicationListener<AbstractApplicationEvent> listener) {
        applicationListeners.add(listener);
    }

    @Override
    public void removeApplicationListener(ApplicationListener<AbstractApplicationEvent> listener) {
        applicationListeners.remove(listener);
    }



    // #######################Event事件广播相关方法#######################

    /**
     * Multicast the given application event to appropriate listeners.
     * @param event                         the event to multicast
     * @return                              the number of listeners that were notified
     */
    protected Collection<ApplicationListener<AbstractApplicationEvent>> getApplicationListeners(AbstractApplicationEvent event) {
        LinkedList<ApplicationListener<AbstractApplicationEvent>> allListeners = new LinkedList<>();
        for (ApplicationListener<AbstractApplicationEvent> listener : applicationListeners) {
            if (supportsEvent(listener, event)) {
                allListeners.add(listener);
            }
        }
        return allListeners;
    }

    /**
     * 监听器是否对该事件感兴趣
     * 判定此 eventClassName 对象所表示的类或接口与指定的
     * event.getClass() 参数所表示的类或接口是否相同，或是否是其超类或超接口。
     * isAssignableFrom是用来判断子类和父类的关系的，或者接口的实现类和接口的关系的，
     * 默认所有的类的终极父类都是Object。
     * 如果A.isAssignableFrom(B)结果是true，证明B可以转换成为A,也就是A可以由B转换而来。
     * @param applicationListener           监听器
     * @param event                         事件
     * @return                              是否感兴趣
     */
    @SuppressWarnings("all")
    protected boolean supportsEvent(ApplicationListener<AbstractApplicationEvent> applicationListener,
                                    AbstractApplicationEvent event) {
        // 获取监听的Class类型
        Class<? extends ApplicationListener> listenerClass = applicationListener.getClass();

        // 获取监听器的泛型类型是否关注这个事件
        return getEventClassNameForListener(listenerClass).isAssignableFrom(event.getClass());
    }

    /**
     * 获取监听器关注事件的泛型类型
     * @param listenerClass             监听器Class
     * @return                          监听器关注事件的泛型类型
     * @throws BeansException           Beans异常
     */
    protected Class<?> getEventClassNameForListener(Class<?> listenerClass) throws BeansException {
        // 按照 CglibSubclassingInstantiationStrategy、SimpleInstantiationStrategy
        // 不同的实例化类型，需要判断后获取目标 class
        Class<?> targetClass = ClassUtils.isCglibProxyClass(listenerClass) ? listenerClass.getSuperclass() : listenerClass;
        Type genericInterface = targetClass.getGenericInterfaces()[0];
        Type actualTypeArgument = ((ParameterizedType) genericInterface).getActualTypeArguments()[0];
        String className = actualTypeArgument.getTypeName();        //获取监听器泛型的Class类型名称
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new BeansException("wrong event class name: " + className);
        }
    }

}
