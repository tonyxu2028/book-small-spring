package cn.bugstack.springframework.core.io;

/**
 * @author naixixu
 */
public interface ResourceLoader {

    /**
     * Pseudo URL prefix for loading from the class path: "classpath:"
     */
    String CLASSPATH_URL_PREFIX = "classpath:";

    /**
     * Return a Resource handle for the specified resource.
     * @param location                      the resource location
     * @return                              the corresponding Resource handle
     */
    Resource getResource(String location);

}
