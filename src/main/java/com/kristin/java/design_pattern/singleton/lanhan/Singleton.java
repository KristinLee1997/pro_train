package com.kristin.java.design_pattern.singleton.lanhan;

/**
 * @author hang li
 * @since 2018/5/11
 * 单例模式--懒汉式(并发时会破坏单例)
 */
public class Singleton {
    private static Singleton singleton;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }

    public static void main(String[] args) {
        Singleton s = Singleton.getInstance();
        Singleton ss = Singleton.getInstance();
        System.out.println(s == ss);
    }
}
