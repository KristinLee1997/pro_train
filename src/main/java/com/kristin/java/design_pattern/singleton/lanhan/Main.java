package com.kristin.java.design_pattern.singleton.lanhan;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author hang li
 * @since 2018/5/11
 * 这种情况并发时会破坏单例
 */
public class Main {
    private static LinkedBlockingQueue<Singleton> linkedBlockingQueue = new LinkedBlockingQueue<>();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            threadPool.execute(() -> {
                linkedBlockingQueue.offer(Singleton.getInstance());
            });
        }

        Singleton singleton = linkedBlockingQueue.take();
        while (singleton == linkedBlockingQueue.take()) {
            System.out.println("continue...");
        }
        System.out.println("单例失败");
    }
}
