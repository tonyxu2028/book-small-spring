package cn.bugstack.springframework.core.io;

/**
 *
 *
 *
 * 作者：DerekYRC <a href="https://github.com/DerekYRC/mini-spring">...</a>
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
     * The handle should always be a reusable resource descriptor,
     * allowing for multiple {@code getResource} calls.
     * <p>Must support fully qualified URLs, e.g. "file:C:/test.dat".
     * <p>Should also support class path URLs, e.g. "classpath:test.dat".
     * This should be suitable for loading resource files from the class path
     * or from any jar file.
     * <p>Does not have to support relative file paths.
     * @param location the resource location
     * @return a corresponding Resource handle
     * @see ClassLoader#getResource(String)
     * @see ClassLoader#getResourceAsStream(String)
     */
    Resource getResource(String location);

}
