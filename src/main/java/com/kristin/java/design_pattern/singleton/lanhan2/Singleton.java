package com.kristin.java.design_pattern.singleton.lanhan2;

/**
 * @author hang li
 * @since 2018/5/11
 * 单例模式--懒汉式(可能会出现一个线程一直处于等待中...这样就不符合实际情况啦)
 */
public class Singleton {
    private static Singleton singleton;

    private Singleton() {
    }

    public static synchronized Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }

    /**
     * 测试实现999999999次单例锁需要的时间: 大约28544ms
     */
    public static void getTime() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 999999999; i++) {
            Singleton s = Singleton.getInstance();
        }
        System.out.println("time is: " + (System.currentTimeMillis() - start));
    }

    public static void main(String[] args) {
        Singleton s = Singleton.getInstance();
        Singleton ss = Singleton.getInstance();
        System.out.println(s == ss);
        getTime();
    }
}
