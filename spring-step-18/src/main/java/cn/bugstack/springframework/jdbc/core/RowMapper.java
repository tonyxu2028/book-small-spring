package cn.bugstack.springframework.jdbc.core;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author naixixu
 * @description An interface used by {@link JdbcTemplate} for mapping rows of a
 * {@link java.sql.ResultSet} on a per-row basis.
 * @date 2022/3/16
 *  /CodeDesignTutorials
 *
 */
public interface RowMapper<T> {

    /**
     * Implementations must implement this method to map each row of data in the
     * @param rs                    the ResultSet to map (pre-initialized for the current row)
     * @param rowNum                the number of the current row
     * @return                      the result object for the current row
     * @throws SQLException         if a SQLException is encountered getting
     */
    T mapRow(ResultSet rs, int rowNum) throws SQLException;

}
