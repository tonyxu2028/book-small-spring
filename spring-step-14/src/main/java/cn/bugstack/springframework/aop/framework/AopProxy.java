package cn.bugstack.springframework.aop.framework;

/**
 * Delegate interface for a configured AOP proxy, allowing for the creation
 * of actual proxy objects.
 *
 * <p>Out-of-the-box implementations are available for JDK dynamic proxies
 * and for CGLIB proxies, as applied by DefaultAopProxyFactory
 * <p>
 * AOP 代理的抽象
 *
 * <p>
 * 博客：<a href="https://bugstack.cn">...</a> - 沉淀、分享、成长，让自己和他人都能有所收获！
 * 公众号：bugstack虫洞栈
 * Create by 小傅哥(fustack)
 * @author naixixu
 */
public interface AopProxy {

    /**
     * Create a new proxy object.
     * @return          the new proxy object (never {@code null})
     */
    Object getProxy();

}
