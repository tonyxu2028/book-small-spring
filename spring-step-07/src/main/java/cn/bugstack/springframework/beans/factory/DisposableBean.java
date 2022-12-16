package cn.bugstack.springframework.beans.factory;

/**
 * {@code @description} Interface to be implemented by beans that want to release resources
 * 作者：DerekYRC <a href="https://github.com/DerekYRC/mini-spring">...</a>
 * @author naixixu
 * @date 2022/3/10
 */
public interface DisposableBean {

    /**
     * 销毁方法
     * @throws Exception            异常
     */
    void destroy() throws Exception;

}
