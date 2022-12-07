package cn.bugstack.springframework.context;

import cn.bugstack.springframework.beans.BeansException;
import cn.bugstack.springframework.beans.factory.Aware;

/**
 *
 *
 *
 * 作者：DerekYRC https://github.com/DerekYRC/mini-spring
 * @author naixixu
 * @description 实现此接口，既能感知到所属的 ApplicationContext
 * @date 2022/3/11
 *  /CodeDesignTutorials
 *
 */
public interface ApplicationContextAware extends Aware {

    /**
     * 设置 ApplicationContext
     * @param applicationContext            应用上下文
     * @throws BeansException               Bean 异常
     */
    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;

}
