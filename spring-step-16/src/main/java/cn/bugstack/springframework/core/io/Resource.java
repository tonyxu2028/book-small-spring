package cn.bugstack.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 *
 *
 *
 * 作者：DerekYRC <a href="https://github.com/DerekYRC/mini-spring">...</a>
 * @author naixixu
 * @description 资源处理接口
 * @date 2022/3/9
 *
 *
 */
public interface Resource {

    /**
     * 获取资源的输入流
     * @return                  输入流
     * @throws IOException      IO异常
     */
    InputStream getInputStream() throws IOException;

}
