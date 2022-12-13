package cn.bugstack.springframework.beans.factory.config;

import cn.bugstack.springframework.beans.factory.HierarchicalBeanFactory;
import cn.bugstack.springframework.core.convert.ConversionService;
import cn.bugstack.springframework.util.StringValueResolver;
import com.sun.istack.internal.Nullable;

/**
 *
 * @author naixixu
 * @description Configuration interface to be implemented by most bean factories. Provides
 * facilities to configure a bean factory, in addition to the bean factory
 * client methods in the {@link cn.bugstack.springframework.beans.factory.BeanFactory}
 * interface.
 * @date 2022/3/9
 *
 *
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

    /**
     * Set the parent of this bean factory.
     * @param beanPostProcessor             the parent bean factory
     */
    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

    /**
     * 销毁单例对象
     */
    void destroySingletons();

    /**
     * Add a String resolver for embedded values such as annotation attributes.
     * @param valueResolver the String resolver to apply to embedded values
     * @since 3.0
     */
    void addEmbeddedValueResolver(StringValueResolver valueResolver);

    /**
     * Resolve the given embedded value, e.g. an annotation attribute.
     * @param value the value to resolve
     * @return the resolved value (may be the original value as-is)
     * @since 3.0
     */
    String resolveEmbeddedValue(String value);

    /**
     * Set the class loader to use for loading bean classes.
     * @param conversionService             the class loader to use,
     */
    void setConversionService(ConversionService conversionService);

    /**
     * Return the class loader to use for loading bean classes.
     * @return                      the associated class loader (never {@code null})
     */
    @Nullable
    ConversionService getConversionService();

}
