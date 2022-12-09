package cn.bugstack.springframework.util;

/**
 *
 *
 *
 * 作者：DerekYRC <a href="https://github.com/DerekYRC/mini-spring">...</a>
 * @author naixixu
 * @description Simple strategy interface for resolving a String value.
 * Used by {@link cn.bugstack.springframework.beans.factory.config.ConfigurableBeanFactory}.
 * @date 2022/3/9
 *  /CodeDesignTutorials
 *
 */
public interface StringValueResolver {

    /**
     * Resolve the given String value, for example parsing placeholders.
     * @param strVal            the original String value (never {@code null})
     * @return                  the resolved String value (may be {@code null} when resolved to a null)
     */
    String resolveStringValue(String strVal);

}
