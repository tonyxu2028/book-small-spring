package cn.bugstack.springframework.core.io;

/**
 * @description 资源加载器接口
 * 作者：DerekYRC <a href="https://github.com/DerekYRC/mini-spring">...</a>
 * @author naixixu
 * @date 2022/3/9
 */
public interface ResourceLoader {

    /**
     * Pseudo URL prefix for loading from the class path: "classpath:"
     */
    String CLASSPATH_URL_PREFIX = "classpath:";

    /**
     * 获取资源
     * @param location  资源路径
     * @return          资源
     */
    Resource getResource(String location);

}
