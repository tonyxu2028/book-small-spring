package cn.bugstack.springframework.beans.factory;

/**
 *
 *
 *
 * 作者：DerekYRC <a href="https://github.com/DerekYRC/mini-spring">...</a>
 * @author naixixu
 * @description 实现此接口的 Bean 对象，会在 BeanFactory 设置属性后作出相应的处理，如：执行自定义初始化，或者仅仅检查是否设置了所有强制属性。
 * @date 2022/3/10
 *  /CodeDesignTutorials
 *
 */
public interface InitializingBean {

    /**
     * Bean 处理了属性填充后调用
     * 
     * @throws Exception            如果在初始化 Bean 时发生异常
     */
    void afterPropertiesSet() throws Exception;

}
