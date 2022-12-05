package cn.bugstack.springframework.test;

import cn.bugstack.springframework.beans.factory.config.BeanDefinition;
import cn.bugstack.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.bugstack.springframework.test.bean.UserService;
import org.junit.Assert;
import org.junit.Test;

/**
 * 作者：DerekYRC <a href="https://github.com/DerekYRC/mini-spring">...</a>
 * {@code @description} 测试类
 * @date 2022/03/07
 *
 *
 */
public class SpringStep02Test {
    @Test
    public void test_BeanFactory(){
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2.创建UserService的BeanDefinition, 并注册到BeanFactory#beanDefinitionMap的容器中
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 3.第一次获取 bean
        // 此时只在BeanFactory#beanDefinitionMap的容器中获取
        // 在创建bean的时候，会将bean放入到BeanFactory#singletonObjectMap的容器中
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();

        // 4.第二次直接从BeanFactory#singletonObjectMap的容器中获取
        UserService userService_singleton = (UserService) beanFactory.getBean("userService");
        Assert.assertEquals(userService, userService_singleton);
        userService_singleton.queryUserInfo();
    }

}
