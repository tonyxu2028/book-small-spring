package cn.bugstack.springframework.core.convert;

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
    @SuppressWarnings("unused")
    boolean canConvert(Class<?> sourceType, Class<?> targetType);

    /**
     * Convert the source to targetType.
     * @param source            the source object to convert (may be {@code null})
     * @param targetType        the target type to convert to (required)
     * @return                  the converted object (potentially {@code null})
     * @param <T>               the target type
     */
    <T> T convert(Object source, Class<T> targetType);

}
