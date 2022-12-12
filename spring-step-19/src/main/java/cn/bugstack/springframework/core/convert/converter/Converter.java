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
     * 转换方法
     * @param source        源对象
     * @return              目标对象
     */
    T convert(S source);

}
