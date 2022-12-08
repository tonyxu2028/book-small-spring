package cn.bugstack.springframework.aop;

/**
 *
 *
 *
 * 作者：DerekYRC https://github.com/DerekYRC/mini-spring
 * @author naixixu
 * @description Superinterface for all Advisors that are driven by a pointcut.
 * This covers nearly all advisors except introduction advisors,
 * for which method-level matching doesn't apply.
 * @date 2022/3/14
 *  /CodeDesignTutorials
 *
 */
public interface PointcutAdvisor extends Advisor {

    /**
     * Return the Pointcut that drives this advisor.
     * @return the Pointcut (never <code>null</code>)
     */
    Pointcut getPointcut();

}
