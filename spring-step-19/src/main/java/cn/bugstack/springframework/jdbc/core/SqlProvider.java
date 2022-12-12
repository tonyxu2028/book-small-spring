package cn.bugstack.springframework.jdbc.core;

/**
 *
 * @author naixixu
 * @description Interface to be implemented by objects that can provide SQL strings.
 * @date 2022/3/16
 *  /CodeDesignTutorials
 *
 */
public interface SqlProvider {

    /**
     * Return the SQL string to execute.
     * @return  the SQL string to execute
     */
    String getSql();

}
