package cn.bugstack.springframework.tx.transaction;

/**
 *
 * @author naixixu
 * @description Common representation of the current state of a transaction.
 * Serves as base interface for {@link TransactionStatus} as well as
 * @date 2022/3/18
 *  /CodeDesignTutorials
 *
 */
@SuppressWarnings("unused")
public interface TransactionExecution {

    /**
     * Return whether this transaction is new, that is, hasn't been suspended.
     * @return                  true if the transaction is new
     */
    boolean isNewTransaction();

    /**
     * Set the transaction rollback-only. This instructs the transaction manager
     * that the only possible outcome of the transaction may be a rollback, as
     * alternative to throwing an exception which would in turn trigger a rollback.
     */
    void setRollbackOnly();

    /**
     * Return whether this transaction has been marked as rollback-only.
     * @return                  true if the transaction has been marked as rollback-only
     */
    boolean isRollbackOnly();

    /**
     * Return whether this transaction is completed, that is, whether it has
     * @return                  true if the transaction is completed
     */
    boolean isCompleted();

}
