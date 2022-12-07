package cn.bugstack.springframework.core.io;

/**
 *
 *
 *
 * 作者：DerekYRC https://github.com/DerekYRC/mini-spring
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
     * 根据资源路径获取资源
     * @param location      资源路径
     * @return              资源
     */
    Resource getResource(String location);

}
