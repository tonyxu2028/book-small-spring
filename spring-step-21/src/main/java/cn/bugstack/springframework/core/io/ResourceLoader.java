package cn.bugstack.springframework.core.io;

/**
 *
 * @author naixixu
 * @description 资源加载器
 * @date 2022/3/9
 *
 *
 */
public interface ResourceLoader {

    /**
     * Pseudo URL prefix for loading from the class path: "classpath:"
     */
    String CLASSPATH_URL_PREFIX = "classpath:";

    /**
     * Return a Resource handle for the specified resource.
     * @param location          the resource location
     * @return                  the corresponding Resource handle
     */
    Resource getResource(String location);

}
