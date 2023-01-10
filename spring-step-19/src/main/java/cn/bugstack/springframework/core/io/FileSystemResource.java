package cn.bugstack.springframework.core.io;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

/**
 *
 * @author naixixu
 * @description 文件资源
 * @date 2022/3/9
 *
 *
 */
public class FileSystemResource implements Resource {

    private final File file;

    private final String path;

    public FileSystemResource(String path) {
        this.file = new File(path);
        this.path = path;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return Files.newInputStream(this.file.toPath());
    }

    @SuppressWarnings("unused")
    public FileSystemResource(File file) {
        this.file = file;
        this.path = file.getPath();
    }

    @SuppressWarnings("unused")
    public final String getPath() {
        return this.path;
    }

}
