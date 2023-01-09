package cn.bugstack.springframework.tx.transaction;

import java.io.Flushable;
import java.io.IOException;

/**
 *
 * @author naixixu
 * @description Default implementation of the TransactionStatus
 * interface, used by AbstractPlatformTransactionManager Based on the concept
 * of an underlying "transaction object".
 * @date 2022/3/16
 *  /CodeDesignTutorials
 *
 */
public interface TransactionStatus extends TransactionExecution, SavepointManager, Flushable {

    /**
     * Return whether this transaction is new, that is, whether it has been
     * @return                      true if the transaction is new
     */
    @SuppressWarnings("unused")
    boolean hasSavepoint();

    /**
     * Return whether this transaction is new, that is, whether the
     * @throws IOException          if thrown by a Flushable operation
     */
    @Override
    void flush() throws IOException;

}
