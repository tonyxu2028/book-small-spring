package cn.bugstack.springframework.beans.factory;

import cn.bugstack.springframework.beans.BeansException;

/**
 * Interface to be implemented by beans that wish to be aware of their
 * owning {@link BeanFactory}.
 * <p>
 * 实现此接口，既能感知到所属的 BeanFactory
 * <p>
 * 博客：<a href="https://bugstack.cn">...</a> - 沉淀、分享、成长，让自己和他人都能有所收获！
 * 公众号：bugstack虫洞栈
 * Create by 小傅哥(fustack)
 * @author naixixu
 */
public interface BeanFactoryAware extends Aware {

   /**
    * Set the {@code BeanFactory} that this object runs in.
    * @param beanFactory                  beanFactory
    * @throws BeansException              bean 异常
    */
   void setBeanFactory(BeanFactory beanFactory) throws BeansException;

}
