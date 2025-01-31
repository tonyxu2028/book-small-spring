package cn.bugstack.springframework.context;

import cn.bugstack.springframework.beans.factory.beanfactory.ListableBeanFactory;

/**
 * 作者：DerekYRC <a href="https://github.com/DerekYRC/mini-spring">...</a>
 * @author naixixu
 * {@code @description} 应用上下文接口 Central interface to provide configuration for an application.
 * This is read-only while the application is running, but may be
 * reloaded if the implementation supports this.
 * @date 2022/3/10
 *
 *
 */
public interface ApplicationContext extends ListableBeanFactory {

}
