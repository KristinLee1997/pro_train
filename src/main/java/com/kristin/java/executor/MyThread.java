package com.kristin.java.executor;

/**
 * @author hang li
 * @since 2018/4/17
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "正在执行...");
    }
}
