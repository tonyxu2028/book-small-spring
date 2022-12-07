package cn.bugstack.springframework.beans.factory;

/**
 *
 *
 *
 * 作者：DerekYRC <a href="https://github.com/DerekYRC/mini-spring">...</a>
 * @author naixixu
 * {@code @description} Interface to be implemented by beans that want to release resources
 * on destruction. A BeanFactory is supposed to invoke the destroy
 * method if it disposes a cached singleton. An application context
 * is supposed to dispose all of its singletons on close.
 * @date 2022/3/10
 *  /CodeDesignTutorials
 *
 */
public interface DisposableBean {

    /**
     * 销毁方法
     * @throws Exception            异常
     */
    void destroy() throws Exception;

}
