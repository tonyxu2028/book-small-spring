package cn.bugstack.springframework.beans.factory;

/**
 * {@code @description} Interface to be implemented by beans that want to be aware of their
 * 作者：DerekYRC <a href="https://github.com/DerekYRC/mini-spring">...</a>
 * @author naixixu
 * @date 2022/3/11
 */
public interface BeanNameAware {

    /**
     * Set the name of the bean in the bean factory that created this bean.
     * @param name          the name of the bean in the factory.
     */
    void setBeanName(String name);

}
