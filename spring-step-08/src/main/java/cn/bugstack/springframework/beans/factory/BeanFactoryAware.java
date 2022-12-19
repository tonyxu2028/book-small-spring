package cn.bugstack.springframework.beans.factory;

import cn.bugstack.springframework.beans.BeansException;

/**
 * {@code @description} 实现此接口，既能感知到所属的 BeanFactory
 * 作者：DerekYRC <a href="https://github.com/DerekYRC/mini-spring">...</a>
 * @author naixixu
 * @date 2022/3/11
 */
public interface BeanFactoryAware extends Aware {

    /**
     * Set the BeanFactory that this object runs in.
     * @param beanFactory               the owning BeanFactory (never {@code null}).
     * @throws BeansException           in case of initialization errors.
     */
    void setBeanFactory(BeanFactory beanFactory) throws BeansException;

}
