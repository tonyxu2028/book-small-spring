package cn.bugstack.springframework.test;

import cn.bugstack.springframework.context.support.ClassPathXmlApplicationContext;
import cn.bugstack.springframework.context.event.CustomEvent;
import org.junit.Test;

/**
 * @description 单元测试
 * 作者：DerekYRC <a href="https://github.com/DerekYRC/mini-spring">...</a>
 * @date 2022/03/10
 */
public class SpringStep10Test {

    @Test
    public void test_event() {

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");

        applicationContext.publishEvent(
                new CustomEvent(applicationContext, 1019129009086763L, "成功了！"));

        applicationContext.registerShutdownHook();
    }

}
