package cn.bugstack.springframework.context;

import cn.bugstack.springframework.beans.BeansException;
import cn.bugstack.springframework.beans.factory.Aware;

/**
 *
 * @author naixixu
 * @description 实现此接口，既能感知到所属的 ApplicationContext
 * @date 2022/3/11
 *  /CodeDesignTutorials
 *
 */
public interface ApplicationContextAware extends Aware {

    /**
     * Set the ApplicationContext that this object runs in.
     * @param applicationContext            the ApplicationContext object to be used by this object
     * @throws BeansException               if the context could not be set
     */
    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;

}
