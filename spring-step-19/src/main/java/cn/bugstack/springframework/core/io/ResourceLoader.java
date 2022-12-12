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
     * 获取资源
     * @param       location
     * @return      Resource
     */
    Resource getResource(String location);

}
