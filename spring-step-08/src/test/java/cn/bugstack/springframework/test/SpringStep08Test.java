package cn.bugstack.springframework.test;

import cn.bugstack.springframework.context.support.ClassPathXmlApplicationContext;
import cn.bugstack.springframework.test.bean.UserService;
import org.junit.Test;

/**
 * {@code @description} 单元测试
 * 作者：DerekYRC <a href="https://github.com/DerekYRC/mini-spring">...</a>
 * @date 2022/03/10
 */
public class SpringStep08Test {

    @Test
    public void test_xml() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("classpath:spring.xml");

        applicationContext.registerShutdownHook();

        // 2. 获取Bean对象调用方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);

        System.out.println("BeanFactoryAware："+userService.getBeanFactory());
        System.out.println("ApplicationContextAware："+userService.getApplicationContext());
    }

}
