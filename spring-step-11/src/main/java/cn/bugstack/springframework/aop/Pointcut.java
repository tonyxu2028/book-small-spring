package cn.bugstack.springframework.aop;

/**
 * @Description:
 * Pointcut 切入点接口Pointcut用于获取ClassFilter和MethodMatcher两个类,
 * 它们都是切点表达式提供的内容。
 * Core Spring pointcut abstraction.
 * <p>A pointcut is composed of a {@link ClassFilter} and a {@link MethodMatcher}.
 * Both these basic terms and a Pointcut itself can be combined to build up combinations
 * <p>
 * 博客：<a href="https://bugstack.cn">...</a> - 沉淀、分享、成长，让自己和他人都能有所收获！
 * 公众号：bugstack虫洞栈
 * Create by 小傅哥(fustack)
 * @author naixixu
 */
public interface Pointcut {

    /**
     * Return the ClassFilter for this pointcut.
     *
     * @return the ClassFilter (never <code>null</code>)
     */
    @SuppressWarnings("unused")
    ClassFilter getClassFilter();

    /**
     * Return the MethodMatcher for this pointcut.
     *
     * @return the MethodMatcher (never <code>null</code>)
     */
    @SuppressWarnings("unused")
    MethodMatcher getMethodMatcher();

}
