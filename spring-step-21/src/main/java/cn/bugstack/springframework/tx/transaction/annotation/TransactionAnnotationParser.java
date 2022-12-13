package cn.bugstack.springframework.tx.transaction.annotation;

import cn.bugstack.springframework.tx.transaction.interceptor.TransactionAttribute;

import java.lang.reflect.AnnotatedElement;

/**
 *
 * @author naixixu
 * @description 用于解析已知事务注释类型的策略接口
 * @date 2022/3/16
 *  /CodeDesignTutorials
 *
 */
public interface TransactionAnnotationParser {

    /**
     * Parse the transaction attribute for the given method or class.
     * @param element               the annotated method or class
     * @return                      the configured transaction attribute, or {@code null} if none was found
     */
    TransactionAttribute parseTransactionAnnotation(AnnotatedElement element);

}
