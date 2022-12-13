package cn.bugstack.springframework.tx.transaction;

/**
 *
 * @author naixixu
 * @description Interface that specifies an API to programmatically manage transaction
 * savepoints in a generic fashion. Extended by TransactionStatus to
 * expose savepoint management functionality for a specific transaction.
 * @date 2022/3/16
 *  /CodeDesignTutorials
 *
 */
public interface SavepointManager {

    /**
     * Create a new savepoint for the current transaction.
     * @return                  Object
     * @throws TransactionException
     */
    Object createSavepoint() throws TransactionException;

    /**
     * Roll back to the given savepoint.
     * @param savepoint         Object
     * @throws TransactionException
     */
    void rollbackToSavepoint(Object savepoint) throws TransactionException;

    /**
     * Release the given savepoint.
     * @param savepoint         Object
     * @throws TransactionException
     */
    void releaseSavepoint(Object savepoint) throws TransactionException;

}
