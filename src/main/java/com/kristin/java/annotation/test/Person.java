package com.kristin.java.annotation.test;

/**
 * @author hang li
 * @since 2018/4/17
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Person {
    private static final Logger logger = LoggerFactory.getLogger(Person.class);

    private static final String NAME = "kristin123";

    @WConfig(NAME)
    private Integer age;

    public static void main(String[] args) {
        new Person().getName(15);
    }

    @WConfig(NAME)
    public Integer getName(Integer age) {
        this.age = age;
        logger.info("年龄:{}", this.age);
        return age;
    }
}
