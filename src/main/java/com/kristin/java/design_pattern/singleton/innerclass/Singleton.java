package com.kristin.java.design_pattern.singleton.innerclass;

/**
 * @author hang li
 * @since 2018/5/11
 */
public class Singleton {
    private Singleton() {

    }

    public static Singleton getInstance() {
        return LazyHolder.singleton;
    }

    /**
     * time is: 6ms
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

    private static class LazyHolder {
        private static Singleton singleton = new Singleton();
    }
}
