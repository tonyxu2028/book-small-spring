package cn.bugstack.springframework.beans.factory;

/**
 *
 *
 *
 * 作者：DerekYRC <a href="https://github.com/DerekYRC/mini-spring">...</a>
 * @author naixixu
 * @description Interface to be implemented by beans that want to be aware of their
 * bean name in a bean factory. Note that it is not usually recommended
 * that an object depend on its bean name, as this represents a potentially
 * brittle dependence on external configuration, as well as a possibly
 * unnecessary dependence on a Spring API.
 * @date 2022/3/11
 *  /CodeDesignTutorials
 *
 */
public interface BeanNameAware {

    /**
     * Set the name of the bean in the bean factory that created this bean.
     * @param name the name of the bean in the factory.
     * Note that this name is the actual bean name used in the factory,
     * which may differ from the originally specified name: in particular
     * for inner bean names, the actual bean name might have been made unique.
     */
    void setBeanName(String name);

}
