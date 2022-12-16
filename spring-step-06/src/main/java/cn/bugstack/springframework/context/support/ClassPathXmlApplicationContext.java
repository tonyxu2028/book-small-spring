package cn.bugstack.springframework.context.support;

import cn.bugstack.springframework.beans.exception.BeansException;

/**
 * {@code @description} XML 文件应用上下文 Standalone XML application context, taking the context definition files
 * 作者：DerekYRC <a href="https://github.com/DerekYRC/mini-spring">...</a>
 * @author naixixu
 * @date 2022/3/10
 */
public class ClassPathXmlApplicationContext extends AbstractXmlApplicationContext {

    private final String[] configLocations;

    /**
     * 从 XML 中加载 BeanDefinition，并刷新上下文
     *
     * @param configLocations       XML 配置文件路径
     * @throws BeansException       Bean 异常
     */
    public ClassPathXmlApplicationContext(String configLocations) throws BeansException {
        this(new String[]{configLocations});
    }

    /**
     * 从 XML 中加载 BeanDefinition，并刷新上下文
     * @param configLocations       XML 配置文件路径
     * @throws BeansException       Bean 异常
     */
    public ClassPathXmlApplicationContext(String[] configLocations) throws BeansException {
        this.configLocations = configLocations;
        refresh();
    }

    @Override
    protected String[] getConfigLocations() {
        return configLocations;
    }

}
