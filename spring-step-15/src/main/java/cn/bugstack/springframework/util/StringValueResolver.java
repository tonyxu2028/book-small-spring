package cn.bugstack.springframework.util;

/**
 * Simple strategy interface for resolving a String value.
 * Used by {@link cn.bugstack.springframework.beans.factory.config.ConfigurableBeanFactory}.
 * <p>
 * 博客：<a href="https://bugstack.cn">...</a> - 沉淀、分享、成长，让自己和他人都能有所收获！
 * 公众号：bugstack虫洞栈
 * Create by 小傅哥(fustack)
 * @author naixixu
 */
public interface StringValueResolver {

    /**
     * Resolve the given String value, for example parsing placeholders.
     * @param strVal                    the original String value (never {@code null})
     * @return                          the resolved String value (may be {@code null} when resolved to a null)
     */
    String resolveStringValue(String strVal);

}
