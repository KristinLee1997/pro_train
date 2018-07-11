package com.kristin.java.annotation.test;

import java.lang.annotation.*;

/**
 * @author hang li
 * @since 2018/4/17
 */
@Documented
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface WConfig {
    String value();
}
