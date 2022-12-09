package cn.bugstack.springframework.core.convert.converter;

/**
 *
 *
 *
 * 作者：DerekYRC https://github.com/DerekYRC/mini-spring
 * @author naixixu
 * @description 类型转换注册接口
 * @date 2022/3/16
 *
 *
 */
public interface ConverterRegistry {

    /**
     * 添加类型转换器
     * @param converter             类型转换器
     */
    void addConverter(Converter<?, ?> converter);

    /**
     * 添加类型转换器
     * @param converter             转换器
     */
    void addConverter(GenericConverter converter);

    /**
     * 添加类型转换器
     * @param converterFactory      转换器工厂
     */
    void addConverterFactory(ConverterFactory<?, ?> converterFactory);

}
