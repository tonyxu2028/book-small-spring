package cn.bugstack.springframework.tx.transaction.interceptor;

import cn.bugstack.springframework.core.MethodClassKey;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author naixixu
 * @description Abstract implementation of {@link TransactionAttributeSource} that caches
 * attributes for methods and implements a fallback policy: 1. specific target
 * method; 2. target class; 3. declaring method; 4. declaring class/interface.
 * @date 2022/3/16
 *  /CodeDesignTutorials
 *
 */
public abstract class AbstractFallbackTransactionAttributeSource implements TransactionAttributeSource {

    private final Map<Object, TransactionAttribute> attributeCache = new ConcurrentHashMap<>(1024);

    private static final TransactionAttribute NULL_TRANSACTION_ATTRIBUTE = new DefaultTransactionAttribute() {
        @Override
        public String toString() {
            return "null";
        }
    };

    @Override
    public TransactionAttribute getTransactionAttribute(Method method, Class<?> targetClass) {
        if (method.getDeclaringClass() == Object.class) {
            return null;
        }
        Object cacheKey = getCacheKey(method, targetClass);
        TransactionAttribute cached = this.attributeCache.get(cacheKey);
        if (null != cached) {
            if (cached == NULL_TRANSACTION_ATTRIBUTE) {
                return null;
            } else {
                return cached;
            }
        } else {
            TransactionAttribute txAttr = computeTransactionAttribute(method);
            if (null == txAttr) {
                this.attributeCache.put(cacheKey, NULL_TRANSACTION_ATTRIBUTE);
            } else {
                this.attributeCache.put(cacheKey, txAttr);
            }
            return txAttr;
        }
    }

    protected Object getCacheKey(Method method, Class<?> targetClass) {
        return new MethodClassKey(method, targetClass);
    }

    protected TransactionAttribute computeTransactionAttribute(Method method) {
        if (!Modifier.isPublic(method.getModifiers())) {
            return null;
        }
        TransactionAttribute txAttr = findTransactionAttribute(method);
        if (null != txAttr) {
            return txAttr;
        }
        return findTransactionAttribute(method.getDeclaringClass());
    }

    /**
     * Find a transaction attribute on the given method, explicitly or
     * @param method            the method to introspect
     * @return                  TransactionAttribute for this method, or {@code null} if the method is non-transactional
     */
    protected abstract TransactionAttribute findTransactionAttribute(Method method);

    /**
     * Find a transaction attribute on the given class, explicitly or
     * @param clazz             the class to introspect
     * @return                  TransactionAttribute for this class, or {@code null} if the class is non-transactional
     */
    protected abstract TransactionAttribute findTransactionAttribute(Class<?> clazz);

}
