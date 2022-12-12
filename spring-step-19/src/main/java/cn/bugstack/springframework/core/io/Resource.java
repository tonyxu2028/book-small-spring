package cn.bugstack.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author naixixu
 * @description 资源处理接口
 * @date 2022/3/9
 *
 *
 */
public interface Resource {

    /**
     * 获取资源输入流
     * @return                  InputStream
     * @throws IOException      IOException
     */
    InputStream getInputStream() throws IOException;

}
