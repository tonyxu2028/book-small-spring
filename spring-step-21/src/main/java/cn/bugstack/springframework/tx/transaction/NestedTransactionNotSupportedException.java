package cn.bugstack.springframework.tx.transaction;

/**
 *
 * @author naixixu
 * @description Exception thrown when attempting to work with a nested transaction
 * but nested transactions are not supported by the underlying backend.
 * @date 2022/3/16
 *  /CodeDesignTutorials
 *
 */
public class NestedTransactionNotSupportedException extends CannotCreateTransactionException{

    public NestedTransactionNotSupportedException(String message) {
        super(message);
    }

    /**
     * Constructor for NestedTransactionNotSupportedException.
     * @param message               the detail message
     * @param cause                 the root cause from the transaction API in use
     */
    public NestedTransactionNotSupportedException(String message, Throwable cause) {
        super(message, cause);
    }
}
