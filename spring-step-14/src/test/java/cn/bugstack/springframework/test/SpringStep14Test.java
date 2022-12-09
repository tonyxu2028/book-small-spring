package cn.bugstack.springframework.test;

import cn.bugstack.springframework.context.support.ClassPathXmlApplicationContext;
import cn.bugstack.springframework.test.bean.IUserService;
import org.junit.Test;

/**
 *
 *
 *
 * 作者：DerekYRC <a href="https://github.com/DerekYRC/mini-spring">...</a>
 * @description 单元测试
 * @date 2022/3/15
 *
 *
 */
public class SpringStep14Test {

    @Test
    public void test_scan() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        System.out.println("测试结果：" + userService.queryUserInfo());
    }

}