package cn.bugstack.springframework.jdbc.core;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author naixixu
 * @description Callback interface used by {@link JdbcTemplate}'s query methods.
 * @date 2022/3/16
 *  /CodeDesignTutorials
 *
 */
public interface ResultSetExtractor<T> {

    /**
     * Implementations must implement this method to process the entire ResultSet.
     * @param rs                        the ResultSet to extract data from
     * @return                          an arbitrary result object, or {@code null} if none
     * @throws SQLException             if a SQLException is encountered getting
     */
    T extractData(ResultSet rs) throws SQLException;

}
