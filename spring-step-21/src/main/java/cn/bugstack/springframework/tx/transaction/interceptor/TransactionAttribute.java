package cn.bugstack.springframework.tx.transaction.interceptor;


import cn.bugstack.springframework.tx.transaction.TransactionDefinition;

/**
 *
 * @author naixixu
 * @description This interface adds a {@code rollbackOn} specification to {@link TransactionDefinition}.
 * @date 2022/3/16
 *  /CodeDesignTutorials
 *
 */
public interface TransactionAttribute extends TransactionDefinition {

    /**
     * Return the qualifier value for this transaction attribute.
     * @param ex            the exception to evaluate
     * @return              the qualifier value, or {@code null} if none
     */
    boolean rollbackOn(Throwable ex);

}
