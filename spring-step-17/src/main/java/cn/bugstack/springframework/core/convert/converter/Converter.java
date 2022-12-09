package cn.bugstack.springframework.core.convert.converter;

/**
 *
 *
 *
 * 作者：DerekYRC <a href="https://github.com/DerekYRC/mini-spring">...</a>
 * @author naixixu
 * @description 类型转换处理接口
 * @date 2022/3/16
 *
 *
 */
public interface Converter<S, T>  {

    /**
     * Convert the source of type S to target type T.
     * @param source the source object to convert, which must be an instance of S (never {@code null})
     * @return the converted object, which must be an instance of T (potentially {@code null})
     * @throws IllegalArgumentException if the source cannot be converted to the desired target type
     */
    T convert(S source);

}
