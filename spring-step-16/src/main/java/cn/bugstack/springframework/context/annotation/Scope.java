package cn.bugstack.springframework.context.annotation;

import java.lang.annotation.*;

/**
 * @author naixixu
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Scope {

    String value() default "singleton";

}
