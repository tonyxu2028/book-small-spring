package cn.bugstack.springframework.jdbc.datasource;

import cn.bugstack.springframework.tx.transaction.support.TransactionSynchronizationManager;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @description Helper class that provides static methods for obtaining JDBC Connections from a {@link javax.sql.DataSource}.
 * @date 2022/3/16
 *  /CodeDesignTutorials
 *
 */
@SuppressWarnings("all")
public abstract class DataSourceUtils {

    /**
     * Obtain a Connection from the given DataSource.
     */
    public static Connection getConnection(DataSource dataSource) {
        try {
            return doGetConnection(dataSource);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to obtain JDBC Connection", e);
        }
    }

    public static Connection doGetConnection(DataSource dataSource) throws SQLException {
        ConnectionHolder conHolder = (ConnectionHolder) TransactionSynchronizationManager.getResource(dataSource);
        if (null != conHolder && conHolder.hasConnection()) {
            return conHolder.getConnection();
        }
        return fetchConnection(dataSource);
    }

    private static Connection fetchConnection(DataSource dataSource) throws SQLException {
        Connection conn = dataSource.getConnection();
        if (null == conn) {
            throw new IllegalArgumentException("DataSource return null from getConnection():" + dataSource);
        }
        return conn;
    }

    public static void releaseConnection(Connection con, DataSource dataSource) {
        try {
            doReleaseConnection(con, dataSource);
        } catch (Exception ignore) {}
    }

    public static void doReleaseConnection(Connection con, DataSource dataSource) throws SQLException {
        if (con == null) {
            return;
        }
        doCloseConnection(con, dataSource);
    }

    public static void doCloseConnection(Connection con, DataSource dataSource) throws SQLException {
        con.close();
    }

}
