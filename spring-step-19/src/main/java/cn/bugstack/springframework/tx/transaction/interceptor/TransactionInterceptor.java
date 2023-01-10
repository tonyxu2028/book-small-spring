package cn.bugstack.springframework.tx.transaction.interceptor;

import cn.bugstack.springframework.tx.transaction.PlatformTransactionManager;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.io.Serializable;

/**
 *
 * @author naixixu
 * @description AOP Alliance MethodInterceptor for declarative transaction
 * @date 2022/3/16
 *  /CodeDesignTutorials
 *
 */
public class TransactionInterceptor extends TransactionAspectSupport implements MethodInterceptor, Serializable {

    public TransactionInterceptor(PlatformTransactionManager ptm, TransactionAttributeSource transactionAttributeSource) {
        // 设置事务管理器
        setTransactionManager(ptm);
        // 设置事务属性源
        setTransactionAttributeSource(transactionAttributeSource);
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        return invokeWithinTransaction(invocation.getMethod(), invocation.getThis().getClass(), invocation::proceed);
    }

}
