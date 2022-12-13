package cn.bugstack.springframework.jdbc.core;

import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author naixixu
 * @description Generic callback interface for code that operates on a JDBC Statement.
 * @date 2022/3/16
 *  /CodeDesignTutorials
 *
 */
public interface StatementCallback<T> {

    /**
     * Gets called by {@code JdbcTemplate.execute} with an active JDBC Statement.
     * @param statement         active JDBC Statement
     * @return                  a result object, or {@code null} if none
     * @throws SQLException     if thrown by a JDBC method
     */
    T doInStatement(Statement statement) throws SQLException;

}
