package cn.bugstack.springframework.core.convert.support;

import cn.bugstack.springframework.core.convert.converter.ConverterRegistry;

/**
 * @description A specialization of {@link GenericConversionService} configured by default
 * 作者：DerekYRC <a href="https://github.com/DerekYRC/mini-spring">...</a>
 * @author naixixu
 * @date 2022/3/16
 */
public class DefaultConversionService extends GenericConversionService{

    public DefaultConversionService() {
        addDefaultConverters(this);
    }

    public static void addDefaultConverters(ConverterRegistry converterRegistry) {
        // 添加各类类型转换工厂
        converterRegistry.addConverterFactory(new StringToNumberConverterFactory());
    }

}
