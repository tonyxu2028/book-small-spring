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
     * @param source            源类型
     * @return                  目标类型
     */
    T convert(S source);

}
