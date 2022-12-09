package cn.bugstack.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author naixixu
 */
public interface Resource {

    /**
     * Return an {@link InputStream} for the content of an underlying resource.
     * @return                          the input stream for the underlying resource (must not be {@code null})
     * @throws IOException              in case of I/O errors
     */
    InputStream getInputStream() throws IOException;

}
