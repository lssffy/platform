package com.sp.framework.annotation;


import java.lang.annotation.*;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SRequestParam {
    String value() default "";
    boolean required() default true;
}
