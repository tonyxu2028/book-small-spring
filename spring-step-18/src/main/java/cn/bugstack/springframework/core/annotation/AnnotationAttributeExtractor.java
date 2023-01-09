package cn.bugstack.springframework.core.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 *
 * @author naixixu
 * @description
 * @date 2022/3/16
 *  /CodeDesignTutorials
 *
 */
public interface AnnotationAttributeExtractor<S> {

    /**
     * Extract the value of the given annotation attribute.
     * @return          the extracted value, or {@code null} if not found
     */
    Class<? extends Annotation> getAnnotationType();

    /**
     * Get the element that is annotated with an annotation of the annotation
     * type supported by this extractor.
     * @return the annotated element, or {@code null} if unknown
     */
    Object getAnnotatedElement();

    /**
     * Extract the value of the given annotation attribute.
     * @return          the extracted value, or {@code null} if not found
     */
    S getSource();

    /**
     * Get the attribute value from the underlying {@linkplain #getSource source}
     * that corresponds to the supplied attribute method.
     * @param attributeMethod an attribute method from the annotation type
     * supported by this extractor
     * @return the value of the annotation attribute
     */
    Object getAttributeValue(Method attributeMethod);

}
