package cn.bugstack.springframework.jdbc.datasource;

import java.sql.Connection;

/**
 *
 * @author naixixu
 * @description Simple interface to be implemented by handles for a JDBC Connection.
 * @date 2022/3/16
 *  /CodeDesignTutorials
 *
 */
public interface ConnectionHandle {

    /**
     * Return the JDBC Connection that this handle manages.
     * @return                    the JDBC Connection
     */
    Connection getConnection();

    /**
     * Release the given JDBC Connection, obtained from this handle.
     * @param con                   the JDBC Connection to release
     * @see java.sql.Connection#close()
     */
    default void releaseConnection(Connection con) {

    }

}
