package cn.bugstack.springframework.jdbc.core;

import java.util.List;
import java.util.Map;

/**
 *
 * @author naixixu
 * @description Interface specifying a basic set of JDBC operations.
 * @date 2022/3/16
 *  /CodeDesignTutorials
 *
 */
public interface JdbcOperations {

    /**
     * Execute a JDBC data access operation, implemented as callback action
     * @param action            callback object that specifies the JDBC action
     * @param closeResources    whether to close JDBC resources (Connection, Statement, ResultSet)
     * @return                  a result object returned by the action, or {@code null}
     * @param <T>               the result typ
     * @throws Exception        in case of JDBC errors
     */
    <T> T execute(StatementCallback<T> action,boolean closeResources) throws Exception;

    /**
     * Execute a JDBC data access operation, implemented as callback action
     * @param sql               SQL query or update to execute
     */
    void execute(String sql);

    /**
     * Execute a JDBC data access operation, implemented as callback action
     * @param sql               SQL query or update to execute
     * @param res               the generated key
     * @return                  the generated key
     * @param <T>               the result typ
     */
    <T> T query(String sql, ResultSetExtractor<T> res);

    /**
     * Execute a JDBC data access operation, implemented as callback action
     * @param sql               SQL query or update to execute
     * @param rowMapper         object that will map one object per row
     * @return                  a result object returned by the action, or {@code null}
     * @param <T>               the result type
     */
    <T> List<T> query(String sql, RowMapper<T> rowMapper);

    /**
     * Execute a JDBC data access operation, implemented as callback action
     * @param sql               SQL query or update to execute
     * @return                  a result object returned by the action, or {@code null}
     */
    List<Map<String, Object>> queryForList(String sql);

}
