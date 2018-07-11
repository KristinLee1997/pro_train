package com.kristin.java.design_pattern.singleton.lanhan3;

/**
 * @author hang li
 * @since 2018/5/11
 * 单例模式--双重校验锁
 */
public class Singleton {
    private static Singleton singleton;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    /**
     * 获取999999999次单例模式(双重校验锁)所需时间: 11ms
     */
    public static void getTime() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 999999999; i++) {
            Singleton s = Singleton.getInstance();
        }
        System.out.println("time is:" + (System.currentTimeMillis() - start));
    }

    public static void main(String[] args) {
        Singleton s = Singleton.getInstance();
        Singleton ss = Singleton.getInstance();
        System.out.println(s == ss);
        getTime();
    }
}
