package com.kristin.java.annotation.demo;

import java.lang.annotation.*;

/**
 * @author hang li
 * @since 2018/4/17
 */

/**
 * 元注解:注解的注解
 */
@Documented
//表示使用该注解的元素应该被javadoc或类似工具文档化,它应用于类型声明,类型声明的注解会影响客户端对注解元素的使用.如果一个类型声明添加了Documented注解，那么它的注解会成为被注解元素的公共API的一部分。

@Target(ElementType.METHOD)
//表示支持注解的程序元素的种类，一些可能的值有TYPE, METHOD, CONSTRUCTOR, FIELD(枚举的常量)等等。如果Target元注解不存在，那么该注解就可以使用在任何程序元素之上。

@Inherited
//表示一个注解类型会被自动继承，如果用户在类声明的时候查询注解类型，同时类声明中也没有这个类型的注解，那么注解类型会自动查询该类的父类，这个过程将会不停地重复，直到该类型的注解被找到为止，或是到达类结构的顶层（Object）。

@Retention(RetentionPolicy.RUNTIME) //表示注解类型保留时间的长短，它接收RetentionPolicy参数，可能的值有SOURCE, CLASS, 以及RUNTIME。
/**
 * @Retention(RetentionPolicy.SOURCE)   //注解仅存在于源码中，在class字节码文件中不包含
 * @Retention(RetentionPolicy.CLASS)     // 默认的保留策略，注解会在class字节码文件中存在，但运行时无法获得，
 * @Retention(RetentionPolicy.RUNTIME)  // 注解会在class字节码文件中存在，在运行时可以通过反射获取到
 * /
 *
/**
 * 一.注解:Java注解是附加在代码中的一些元信息，用于一些工具在编译、运行时进行解析和使用，起到说明、配置的功能。注解不会也不能影响代码的实际逻辑，仅仅起到辅助性的作用。包含在 java.lang.annotation 包中
 *
 * 二.注解分类:
 * 1.一般注解:@Generated
 * 2.标记注解:
 * (1).@Override
 * (2).@Deprecated
 * (3).@SuppressWarnings
 * 3.标准元注解:
 *  (1).@Documented
 *  (2).@Inherited
 *  (3).@Retention
 *  (4).@Target
 *
 * 三.注解的注意事项:
 * 1.注解方法不能有参数
 * 2.注解方法的返回类型局限于原始类型,字符串,枚举,注解,或以上类型构成的数组
 * 3.注解方法可以包含默认值
 * 4.注解可以包含与其绑定的元注解,元注解为注解提供信息,
 */
public @interface MethodInfo {

    String author() default "Kristin";

    String date();

    int revision() default 1;

    String comments();
}
