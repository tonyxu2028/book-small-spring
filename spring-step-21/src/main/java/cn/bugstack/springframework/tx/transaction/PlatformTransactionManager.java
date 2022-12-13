package cn.bugstack.springframework.tx.transaction;

/**
 *
 * @author naixixu
 * @description This is the central interface in Spring's imperative transaction infrastructure.
 * Applications can use this directly, but it is not primarily meant as an API:
 * Typically, applications will work with either TransactionTemplate or
 * declarative transaction demarcation through AOP.
 * @date 2022/3/16
 *  /CodeDesignTutorials
 *
 */
public interface PlatformTransactionManager {

    /**
     * Return a currently active transaction or create a new one.
     * @param definition TransactionDefinition instance, describing
     * propagation behavior, isolation level, timeout etc.
     * @return TransactionStatus representing the new or current transaction.
     * Never returns {@code null}.
     * @throws TransactionException in case of lookup, creation, or system errors.
     */
    TransactionStatus getTransaction(TransactionDefinition definition) throws TransactionException;

    /**
     * Commit the given transaction, with regard to its status.
     * @param status object obtained from the current transaction
     * @throws TransactionException in case of commit or system errors.
     */
    void commit(TransactionStatus status) throws TransactionException;

    /**
     * Roll back the given transaction, with regard to its status.
     * @param status object obtained from the current transaction
     * @throws TransactionException in case of system errors.
     */
    void rollback(TransactionStatus status) throws TransactionException;

}
