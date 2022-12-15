package cn.bugstack.springframework.beans.factory.beanfactory;

/**
 * @Description: ConfigurableBeanFactory是一个可以获取BeanPostProcessor,BeanClassLoader等方法的配置化接口。
 * 作者：DerekYRC <a href="https://github.com/DerekYRC/mini-spring">...</a>
 * @author naixixu
 * @date 2022/3/9
 *
 *
 */
@SuppressWarnings("unused")
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

}
