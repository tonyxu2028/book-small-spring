package cn.bugstack.springframework.core.convert.converter;

/**
 *
 * @author naixixu
 * @description 类型转换处理接口
 * @date 2022/3/16
 *
 *
 */
public interface Converter<S, T>  {

    /**
     * Convert the source of type S to target type T.
     * @param source            the source object to convert, which must be an instance of S (never {@code null})
     * @return                  the converted object, which must be an instance of T (potentially {@code null})
     */
    T convert(S source);

}
