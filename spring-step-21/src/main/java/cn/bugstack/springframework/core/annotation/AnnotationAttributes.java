package cn.bugstack.springframework.core.annotation;

import cn.hutool.core.lang.Assert;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.util.LinkedHashMap;

/**
 *
 * @author naixixu
 * @description {@link LinkedHashMap} subclass representing annotation attribute
 * <em>key-value</em> pairs as read by {@link AnnotationUtils},
 * {@link AnnotatedElementUtils}, and Spring's reflection- and ASM-based AnnotationMetadata implementations.
 * @date 2022/3/16
 *  /CodeDesignTutorials
 *
 */
public class AnnotationAttributes extends LinkedHashMap<String, Object> {

    private final Class<? extends Annotation> annotationType;

    boolean validated = false;

    final String displayName;

    public AnnotationAttributes(Class<? extends Annotation> annotationType) {
        Assert.notNull(annotationType, "'annotationType' must not be null");
        this.annotationType = annotationType;
        this.displayName = annotationType.getName();
    }


    public Class<?>[] getClassArray(String attributeName) {
        return getRequiredAttribute(attributeName);
    }

    @SuppressWarnings("unchecked")
    private <T> T getRequiredAttribute(String attributeName) {
        Object value = get(attributeName);

        if (!(value instanceof Class[]) && Class[].class.isArray() &&
                Class[].class.getComponentType().isInstance(value)) {
            Object array = Array.newInstance(Class[].class.getComponentType(), 1);
            Array.set(array,0,value);
            value=array;
        }

        return (T) value;
    }

    public Class<? extends Annotation> annotationType() {
        return this.annotationType;
    }
}
