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
     * @return      boolean
     */
    boolean hasSavepoint();

    /**
     * Return whether this transaction is new, that is, whether it has been
     * @return              boolean
     * @throws IOException  IOException
     */
    @Override
    void flush() throws IOException;

}
