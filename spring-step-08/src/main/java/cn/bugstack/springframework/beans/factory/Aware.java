package cn.bugstack.springframework.beans.factory;

/**
 * @description 标记类接口，实现该接口可以被Spring容器感知
 * 在Spring中，有很多类实现了该接口，比如BeanFactoryAware、BeanClassLoaderAware、BeanNameAware等
 * 它们的存在就是一种标签，便于统一获取出属于此类接口的实现类。
 * 作者：DerekYRC <a href="https://github.com/DerekYRC/mini-spring">...</a>
 * @author naixixu
 * @date 2022/3/11
 */
public interface Aware {

}
