package cn.bugstack.springframework.beans.factory.read;

import cn.bugstack.springframework.beans.factory.beanfactory.BeanDefinitionRegistry;
import cn.bugstack.springframework.core.io.impl.DefaultResourceLoader;
import cn.bugstack.springframework.core.io.ResourceLoader;

/**
 * @Description: AbstractBeanDefinitionReader是BeanDefinitionReader的抽象实现类（基类实现）
 * 这个抽象类目前只负责获取BeanDefinition注册表和资源加载器
 * 作者：DerekYRC <a href="https://github.com/DerekYRC/mini-spring">...</a>
 * @author naixixu
 * {@code @description} Abstract base class for bean definition readers which implement
 * the {@link BeanDefinitionReader} interface.
 * @date 2022/3/9
 *
 *
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {

    private final BeanDefinitionRegistry registry;

    private final ResourceLoader resourceLoader;

    protected AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this(registry, new DefaultResourceLoader());
    }

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        this.registry = registry;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }

}
