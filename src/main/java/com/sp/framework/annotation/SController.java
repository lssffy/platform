package com.sp.framework.annotation;

import java.lang.annotation.*;

/**
 * @author : lssffy
 * @Description :
 * @date : 2024/1/28 15:50
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SController {
    String value() default "";
}
