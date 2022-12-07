package cn.bugstack.springframework.beans.factory;

import cn.bugstack.springframework.beans.BeansException;

/**
 *
 *
 *
 * 作者：DerekYRC <a href="https://github.com/DerekYRC/mini-spring">...</a>
 * @author naixixu
 * @description 实现此接口，既能感知到所属的 BeanFactory
 * @date 2022/3/11
 *  /CodeDesignTutorials
 *
 */
public interface BeanFactoryAware extends Aware {

    /**
     * 设置 BeanFactory
     * @param beanFactory           BeanFactory
     * @throws BeansException       异常
     */
    void setBeanFactory(BeanFactory beanFactory) throws BeansException;

}
