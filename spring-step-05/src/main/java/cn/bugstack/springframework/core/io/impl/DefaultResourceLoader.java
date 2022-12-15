package cn.bugstack.springframework.core.io.impl;

import cn.bugstack.springframework.core.io.Resource;
import cn.bugstack.springframework.core.io.ResourceLoader;
import cn.hutool.core.lang.Assert;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Description: 默认实现的资源加载处理器
 * 作者：DerekYRC <a href="https://github.com/DerekYRC/mini-spring">...</a>
 * @author naixixu
 * @date 2022/3/9
 */
public class DefaultResourceLoader implements ResourceLoader {

    @Override
    public Resource getResource(String location) {
        Assert.notNull(location, "Location must not be null");
        // 如果是以classpath:开头的，就是从类路径下加载资源
        if (location.startsWith(CLASSPATH_URL_PREFIX)) {
            return new ClassPathResource(location.substring(CLASSPATH_URL_PREFIX.length()));
        }
        else {
            try {
                // 尝试将location转换为URL
                URL url = new URL(location);
                return new UrlResource(url);
            } catch (MalformedURLException e) {
                // 如果转换失败，就按照文件的方式加载
                return new FileSystemResource(location);
            }
        }
    }

}
