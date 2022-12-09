package cn.bugstack.springframework.core.convert;

import com.sun.istack.internal.Nullable;

/**
 *
 *
 *
 * 作者：DerekYRC <a href="https://github.com/DerekYRC/mini-spring">...</a>
 * @author naixixu
 * @description 类型转换抽象接口
 * @date 2022/3/16
 *
 *
 */
public interface ConversionService {

    /**
     * Determine whether the given source type can be converted to the target type.
     * @param sourceType            源类型
     * @param targetType            目标类型
     * @return                      是否可以转换
     */
    boolean canConvert(@Nullable Class<?> sourceType, Class<?> targetType);

    /**
     * Convert the source to the target type.
     * @param source                源对象
     * @param targetType            源类型
     * @return                      目标对象
     */
    <T> T convert(Object source, Class<T> targetType);

}
