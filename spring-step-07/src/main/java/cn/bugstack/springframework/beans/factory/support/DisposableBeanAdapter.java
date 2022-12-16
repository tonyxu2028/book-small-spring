package cn.bugstack.springframework.beans.factory.support;

import cn.bugstack.springframework.beans.BeansException;
import cn.bugstack.springframework.beans.factory.DisposableBean;
import cn.bugstack.springframework.beans.factory.config.BeanDefinition;
import cn.hutool.core.util.StrUtil;

import java.lang.reflect.Method;

/**
 * {@code @description} Adapter that implements the
 * {@link DisposableBean} and {@link Runnable} interfaces
 * 作者：DerekYRC <a href="https://github.com/DerekYRC/mini-spring">...</a>
 * @author naixixu
 * performing various destruction steps on a given bean instance:
 * @date 2022/3/10
 *  /CodeDesignTutorials
 *
 */
public class DisposableBeanAdapter implements DisposableBean {
    private static final String DESTROY_METHOD_NAME = "destroy";

    private final Object bean;
    private final String beanName;
    private final String destroyMethodName;

    public DisposableBeanAdapter(Object bean, String beanName, BeanDefinition beanDefinition) {
        this.bean = bean;
        this.beanName = beanName;
        this.destroyMethodName = beanDefinition.getDestroyMethodName();
    }

    @Override
    public void destroy() throws Exception {
        // 1. 实现接口 DisposableBean
        if (bean instanceof DisposableBean) {
            ((DisposableBean) bean).destroy();
        }

        // 2. 注解配置 destroy-method {判断是为了避免二次执行销毁}
        boolean isDestroy = StrUtil.isNotEmpty(destroyMethodName) && !(bean instanceof DisposableBean && DESTROY_METHOD_NAME.equals(destroyMethodName));
        if (isDestroy) {
            Method destroyMethod = bean.getClass().getMethod(destroyMethodName);
            if (null == destroyMethod) {
                throw new BeansException("Couldn't find a destroy method named '" + destroyMethodName + "' on bean with name '" + beanName + "'");
            }
            destroyMethod.invoke(bean);
        }
        
    }

}
