package cn.bugstack.springframework.aop;

import java.lang.reflect.Method;

/**
 * Part of a {@link Pointcut}: Checks whether the target method is eligible for advice.
 * <p>
 * 博客：<a href="https://bugstack.cn">...</a> - 沉淀、分享、成长，让自己和他人都能有所收获！
 * 公众号：bugstack虫洞栈
 * Create by 小傅哥(fustack)
 * @author naixixu
 */
public interface MethodMatcher {

    /**
     * Perform static checking whether the given method matches.
     * <p>The default implementation always returns {@code true}.
     *
     * @param method the candidate method
     * @param targetClass the target class (may be {@code null}, in which case the declaring class of the
     * @return whether or not this method matches statically
     */
    boolean matches(Method method, Class<?> targetClass);
    
}
