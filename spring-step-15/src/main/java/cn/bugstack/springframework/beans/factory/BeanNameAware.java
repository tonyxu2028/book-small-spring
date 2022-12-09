package cn.bugstack.springframework.beans.factory;

/**
 * Interface to be implemented by beans that want to be aware of their
 * bean name in a bean factory. Note that it is not usually recommended
 * that an object depend on its bean name, as this represents a potentially
 * brittle dependence on external configuration, as well as a possibly
 * unnecessary dependence on a Spring API.
 *
 * 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 * 公众号：bugstack虫洞栈
 * Create by 小傅哥(fustack)
 * @author naixixu
 */
public interface BeanNameAware extends Aware {

    /**
     * Set the name of the bean in the bean factory that created this bean.
     * @param name                      the name of the bean in the factory.
     */
    void setBeanName(String name);

}

