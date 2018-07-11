package com.kristin.java.jvm.classloader;

import org.junit.Test;

/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2018/6/10 14:47
 * @desc 哪些情况都不会触发类初始化
 **/
public class TestClassInit {
    //    static int i = 0;
    private static int value = 0;

    static {
        int i = 3;
        System.out.println(i);
    }

    /**
     * 1.当子类引用父类的静态字段时,不会触发子类的初始化
     */
    @Test
    public void test1() {
        System.out.println(SubClass.value);
    }

    /**
     * 2.触发了名为"[Lorg.fenixsoft.classloading.SuperClass]"的类初始化,创建动作指令为newarray
     */
    @Test
    public void test2() {
        SubClass[] subClasses = new SubClass[10];
    }

    /**
     * HELLOWORLD被存储在常量池,所以SuperClass.HELLOWORLD转化为TestClassInit对HELLOWORLD的引用
     */
    @Test
    public void test3() {
        System.out.println(SuperClass.HELLOWORLD);
    }

    @Test
    public void test() {
        System.out.println(TestClassInit.value);
    }
}

class SuperClass {
    public static final String HELLOWORLD = "hello world";
    public static int value = 10;

    static {
        System.out.println("super class init");
    }
}

class SubClass extends SuperClass {
    static {
        System.out.println("sub class init");
    }
}
