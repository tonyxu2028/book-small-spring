package cn.bugstack.springframework.test.processor;

import cn.bugstack.springframework.beans.exception.BeansException;
import cn.bugstack.springframework.beans.factory.beanfactory.BeanPostProcessor;
import cn.bugstack.springframework.test.bean.UserService;

/**
 * {@code @description} BeanPostProcessor 在 Bean 对象执行初始化方法前后进行扩展
 * 作者：DerekYRC <a href="https://github.com/DerekYRC/mini-spring">...</a>
 * @date 2022/03/10
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("userService".equals(beanName)) {
            UserService userService = (UserService) bean;
            userService.setLocation("从深圳改为：北京");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

}
