package com.kristin.java.design_pattern.singleton.enumsingleton;

/**
 * @author hang li
 * @since 2018/5/11
 */
public enum Singleton {
    INSTANCE;
    private String name;

    Singleton() {
        this.name = "kristin";
    }

    public static Singleton getInstance() {
        return INSTANCE;
    }

    /**
     * time is : 31ms
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

    public String getName() {
        return this.name;
    }
}
