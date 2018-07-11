package com.kristin.java.design_pattern.singleton.ehan;

import java.lang.reflect.Constructor;

/**
 * @author hang li
 * @since 2018/5/11
 * 单例模式--饿汉式(可能会被反射修改内部结构,破坏单例)
 */
public class Singleton {
    private static Singleton singleton = new Singleton();

    private Singleton() {

    }

    public static Singleton getSingleton() {
        return singleton;
    }

    public static void test1() {
        Singleton s = Singleton.getSingleton();
        Singleton ss = Singleton.getSingleton();
        System.out.println(s == ss);
    }

    public static void test2() throws Exception {
        Singleton s = Singleton.getSingleton();

        Constructor constructor = Singleton.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        Singleton ss = (Singleton) constructor.newInstance();
        System.out.println(s == ss);
    }

    public static void main(String[] args) {
        test1();
        try {
            test2();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
