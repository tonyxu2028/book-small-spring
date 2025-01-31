package cn.bugstack.springframework.test.converter;

import cn.bugstack.springframework.core.convert.converter.Converter;

/**
 * 博客：<a href="https://bugstack.cn">...</a> - 沉淀、分享、成长，让自己和他人都能有所收获！
 * 公众号：bugstack虫洞栈
 * Create by 小傅哥(fustack)
 */
public class StringToIntegerConverter implements Converter<String, Integer> {

    @Override
    public Integer convert(String source) {
        return Integer.valueOf(source);
    }

}
