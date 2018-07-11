package com.kristin.java.concurrent;

/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2018/6/19 8:24
 * @desc
 **/
public class DeadLock {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (lock1) {
                System.out.println("获得lock1锁,尝试获得lock2");
                synchronized (lock2) {
                    System.out.println("获得lock1,lock2");
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (lock2) {
                System.out.println("获得lock2锁,尝试获得lock1");
                synchronized (lock1) {
                    System.out.println("获得lock1,lock2");
                }
            }
        }
        ).start();
    }
}
