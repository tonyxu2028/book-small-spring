package cn.bugstack.springframework.aop;

import java.lang.reflect.Method;

/**
 * @Description:
 * 方法匹配用于找到表达式范围内匹配的目标类和方法,
 * 在上面的实例中体现为MethodMatcher.matches(Method method,targetObj.getClass())方法。
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
     * <p>This method will be invoked once, before any runtime matching.
     * @param method the candidate method
     * @param targetClass the target class (may be {@code null}, in which case
     * the declaring class of the method must be used)
     * @return whether or not this is a match
     */
    boolean matches(Method method, Class<?> targetClass);
    
}
