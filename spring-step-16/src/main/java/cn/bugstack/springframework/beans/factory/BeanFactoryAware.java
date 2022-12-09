package cn.bugstack.springframework.beans.factory;

import cn.bugstack.springframework.beans.BeansException;

/**
 *
 *
 *
 * 作者：DerekYRC https://github.com/DerekYRC/mini-spring
 * @author naixixu
 * @description 实现此接口，既能感知到所属的 BeanFactory
 * @date 2022/3/11
 *  /CodeDesignTutorials
 *
 */
public interface BeanFactoryAware extends Aware {

    /**
     * Set the BeanFactory that this object runs in.
     * @param beanFactory           the owning BeanFactory
     * @throws BeansException       in case of initialization errors
     */
    void setBeanFactory(BeanFactory beanFactory) throws BeansException;

}
