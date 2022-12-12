package cn.bugstack.springframework.tx.transaction;

/**
 *
 * @author naixixu
 * @description Interface that specifies an API to programmatically manage transaction
 * savepoint in a generic fashion. Extended by TransactionStatus to
 * expose savepoint management functionality for a specific transaction.
 * @date 2022/3/16
 *  /CodeDesignTutorials
 *
 */
@SuppressWarnings("all")
public interface SavepointManager {

    Object createSavepoint() throws TransactionException;

    void rollbackToSavepoint(Object savepoint) throws TransactionException;

    void releaseSavepoint(Object savepoint) throws TransactionException;

}
