package cn.bugstack.springframework.tx.transaction.interceptor;

import cn.bugstack.springframework.beans.BeansException;
import cn.bugstack.springframework.beans.factory.BeanFactory;
import cn.bugstack.springframework.beans.factory.BeanFactoryAware;
import cn.bugstack.springframework.beans.factory.InitializingBean;
import cn.bugstack.springframework.tx.transaction.PlatformTransactionManager;
import cn.bugstack.springframework.tx.transaction.TransactionStatus;
import cn.bugstack.springframework.util.ClassUtils;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.thread.threadlocal.NamedThreadLocal;

import java.lang.reflect.Method;

/**
 * @description 事务的控制都需要被切面支撑类TransactionAspectSupport来进行包装处理,
 * 以便提交和回归事务。
 * @author naixixu
 * @date 2022/3/16
 */
public abstract class TransactionAspectSupport implements BeanFactoryAware, InitializingBean {

    private static final ThreadLocal<TransactionInfo> transactionInfoHolder =
            new NamedThreadLocal<>("Current aspect-driven transaction");

    private TransactionAttributeSource transactionAttributeSource;

    private PlatformTransactionManager transactionManager;

    protected Object invokeWithinTransaction(Method method, Class<?> targetClass, InvocationCallback invocation) throws Throwable {
        TransactionAttributeSource tas = getTransactionAttributeSource();
        // 查找事务注解 Transactional
        TransactionAttribute txAttr = (tas != null ? tas.getTransactionAttribute(method, targetClass) : null);

        PlatformTransactionManager manager = determineTransactionManager();
        String joinPointIdentification = methodIdentification(method, targetClass);
        TransactionInfo txInfo = createTransactionIfNecessary(manager, txAttr, joinPointIdentification);

        Object retVal;
        try {
            retVal = invocation.proceedWithInvocation();
        } catch (Throwable e) {
            completeTransactionAfterThrowing(txInfo, e);
            throw e;
        } finally {
            cleanupTransactionInfo(txInfo);
        }
        commitTransactionAfterReturning(txInfo);

        return retVal;
    }

    /**
     * 当前使用DataSourceTransactionManager
     */
    protected PlatformTransactionManager determineTransactionManager() {
        return getTransactionManager();
    }

    /**
     * 获取目标方法的唯一标识
     */
    private String methodIdentification(Method method, Class<?> targetClass) {
        return ClassUtils.getQualifiedMethodName(method, targetClass);
    }

    protected TransactionInfo createTransactionIfNecessary(PlatformTransactionManager tm, TransactionAttribute txAttr, String joinPointIdentification) {
        if (txAttr != null && txAttr.getName() == null) {
            txAttr = new DelegatingTransactionAttribute(txAttr) {
                @Override
                public String getName() {
                    return joinPointIdentification;
                }
            };
        }

        TransactionStatus status = null;
        if (txAttr != null) {
            if (tm != null) {
                status = tm.getTransaction(txAttr);
            }
        }
        return prepareTransactionInfo(tm, txAttr, joinPointIdentification, status);
    }
    protected TransactionInfo prepareTransactionInfo(PlatformTransactionManager tm, TransactionAttribute txAttr, String joinPointIdentification, TransactionStatus status) {
        TransactionInfo txInfo = new TransactionInfo(tm, txAttr, joinPointIdentification);
        if (txAttr != null) {
            txInfo.newTransactionStatus(status);
        }
        txInfo.bindToThread();
        return txInfo;
    }

    protected interface InvocationCallback {
        Object proceedWithInvocation() throws Throwable;
    }

    protected void completeTransactionAfterThrowing(TransactionInfo txInfo, Throwable ex) {
        if (null != txInfo && null != txInfo.getTransactionStatus()) {
            if (txInfo.transactionAttribute != null && txInfo.transactionAttribute.rollbackOn(ex)) {
                txInfo.getTransactionManager().rollback(txInfo.getTransactionStatus());
            } else {
                txInfo.getTransactionManager().commit(txInfo.getTransactionStatus());
            }
        }
    }

    protected void cleanupTransactionInfo(TransactionInfo txInfo) {
        if (null != txInfo) {
            txInfo.restoreThreadLocalStatus();
        }
    }

    protected void commitTransactionAfterReturning(TransactionInfo txInfo) {
        if (null != txInfo && null != txInfo.getTransactionStatus()) {
            txInfo.getTransactionManager().commit(txInfo.getTransactionStatus());
        }
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {

    }

    public TransactionAttributeSource getTransactionAttributeSource() {
        return transactionAttributeSource;
    }

    public void setTransactionAttributeSource(TransactionAttributeSource transactionAttributeSource) {
        this.transactionAttributeSource = transactionAttributeSource;
    }

    public PlatformTransactionManager getTransactionManager() {
        return transactionManager;
    }

    public void setTransactionManager(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    @Override
    public void afterPropertiesSet() {

    }

    protected static final class TransactionInfo {

        private final PlatformTransactionManager transactionManager;
        private final TransactionAttribute transactionAttribute;
        private final String joinPointIdentification;
        private TransactionStatus transactionStatus;
        private TransactionInfo oldTransactionInfo;

        public TransactionInfo(PlatformTransactionManager transactionManager,
                               TransactionAttribute transactionAttribute,
                               String joinpointIdentification) {
            this.transactionManager = transactionManager;
            this.transactionAttribute = transactionAttribute;
            this.joinPointIdentification = joinpointIdentification;
        }

        public PlatformTransactionManager getTransactionManager() {
            Assert.state(this.transactionManager != null, "No PlatformTransactionManager set");
            return transactionManager;
        }

        public void newTransactionStatus(TransactionStatus status) {
            this.transactionStatus = status;
        }

        public TransactionStatus getTransactionStatus() {
            return transactionStatus;
        }

        private void bindToThread() {
            this.oldTransactionInfo = transactionInfoHolder.get();
            transactionInfoHolder.set(this);
        }

        private void restoreThreadLocalStatus() {
            transactionInfoHolder.set(this.oldTransactionInfo);
        }

        @SuppressWarnings("unused")
        public boolean hasTransaction() {
            return null != this.transactionStatus;
        }

        @SuppressWarnings("unused")
        public String getJoinPointIdentification() {
            return joinPointIdentification;
        }

        @SuppressWarnings("unused")
        public TransactionAttribute getTransactionAttribute() {
            return transactionAttribute;
        }
    }

}
