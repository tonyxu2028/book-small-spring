package cn.bugstack.springframework.beans.factory;

import cn.bugstack.springframework.beans.BeansException;

/**
 *
 * @author naixixu
 * @description 实现此接口，既能感知到所属的 BeanFactory
 * @date 2022/3/11
 *  /CodeDesignTutorials
 *
 */
public interface BeanFactoryAware extends Aware {

    /**
     * Set the BeanFactory that this object runs in.
     * @param beanFactory           the BeanFactory object to be used by this object
     * @throws BeansException       in case of initialization errors
     */
    void setBeanFactory(BeanFactory beanFactory) throws BeansException;

}
