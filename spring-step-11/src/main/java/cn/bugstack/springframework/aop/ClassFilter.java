package cn.bugstack.springframework.aop;

/**
 * @Description:
 * ClassFilter接口定义匹配类,用于帮助切点找到给定的接口和目标类。
 * Filter that restricts matching of a pointcut or introduction to
 * a given set of target classes.
 * <p>
 * 博客：<a href="https://bugstack.cn">...</a> - 沉淀、分享、成长，让自己和他人都能有所收获！
 * 公众号：bugstack虫洞栈
 * Create by 小傅哥(fustack)
 * @author naixixu
 */
public interface ClassFilter {

    /**
     * Should the pointcut apply to the given interface or target class?
     * @param clazz the candidate target class
     * @return whether the advice should apply to the given target class
     */
    boolean matches(Class<?> clazz);

}
