package cn.bugstack.springframework.core.convert;

import com.sun.istack.internal.Nullable;

/**
 *
 * @author naixixu
 * @description 类型转换抽象接口
 * @date 2022/3/16
 *
 *
 */
public interface ConversionService {

    /**
     * 判断是否支持转换
     * @param sourceType            源类型
     * @param targetType            目标类型
     * @return                      是否支持
     */
    boolean canConvert(@Nullable Class<?> sourceType, Class<?> targetType);

    /**
     * 转换
     * @param source                源对象
     * @param targetType            目标类型
     * @return                      目标对象
     * @param <T>                   目标类型
     */
    <T> T convert(Object source, Class<T> targetType);

}
