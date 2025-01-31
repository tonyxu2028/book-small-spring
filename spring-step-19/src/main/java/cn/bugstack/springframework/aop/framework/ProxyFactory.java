package cn.bugstack.springframework.aop.framework;

import cn.bugstack.springframework.aop.AdvisedSupport;

/**
 *
 * @author naixixu
 * @description Factory for AOP proxies for programmatic use, rather than via a bean
 * factory. This class provides a simple way of obtaining and configuring
 * AOP proxies in code.
 * @date 2022/3/14
 *  /CodeDesignTutorials
 *
 */
public class ProxyFactory {

    private final AdvisedSupport advisedSupport;

    public ProxyFactory(AdvisedSupport advisedSupport) {
        this.advisedSupport = advisedSupport;
    }

    public Object getProxy() {
        return createAopProxy().getProxy();
    }

    private AopProxy createAopProxy() {
        if (advisedSupport.isProxyTargetClass()) {
            return new Cglib2AopProxy(advisedSupport);
        }

        return new JdkDynamicAopProxy(advisedSupport);
    }

}
