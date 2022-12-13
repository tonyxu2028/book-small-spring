package cn.bugstack.springframework.beans.factory.config;

/**
 *
 *
 *
 * 作者：DerekYRC <a href="https://github.com/DerekYRC/mini-spring">...</a>
 * @author naixixu
 * {@code @description} 定义 Bean 实例信息
 * @date 2022/03/07
 *
 *
 */
public class  BeanDefinition {

    private final Class<?> beanClass;

    public BeanDefinition(Class<?> beanClass) {
        this.beanClass = beanClass;
    }

    public Class<?> getBeanClass() {
        return beanClass;
    }

}
