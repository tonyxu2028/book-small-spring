package cn.bugstack.springframework.tx.transaction.interceptor;

import java.lang.reflect.Method;

/**
 *
 * @author naixixu
 * @description Strategy interface used by {@link TransactionInterceptor} for metadata retrieval.
 * @date 2022/3/16
 *  /CodeDesignTutorials
 *
 */
public interface TransactionAttributeSource {

    /**
     * Return the transaction attribute for this method invocation,
     * @param method                        the method being invoked
     * @param targetClass                   the target class (may be {@code null}, in which case the declaring class of the
     * @return                              the transaction attribute, or {@code null} if the method is non-transactional
     */
    TransactionAttribute getTransactionAttribute(Method method, Class<?> targetClass);

}
