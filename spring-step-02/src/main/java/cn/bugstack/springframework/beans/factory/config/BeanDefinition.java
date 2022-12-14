package cn.bugstack.springframework.beans.factory.config;

/**
 * @Description: 定义Bean实例信息类
 * @author naixixu
 * @date 2022/03/07
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
