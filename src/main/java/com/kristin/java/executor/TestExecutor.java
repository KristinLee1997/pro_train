package com.kristin.java.executor;

/**
 * @author hang li
 * @since 2018/4/17
 */

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class TestExecutor {
    @Test
    public void testSingleThreadExecutorPool() {
        ExecutorService pool = Executors.newSingleThreadExecutor();
        Thread t1 = new MyThread();
        Thread t2 = new MyThread();
        Thread t3 = new MyThread();
        Thread t4 = new MyThread();
        Thread t5 = new MyThread();
        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        pool.execute(t4);
        pool.execute(t5);
        pool.shutdown();
        /*
         pool-1-thread-1正在执行...
         pool-1-thread-1正在执行...
         pool-1-thread-1正在执行...
         pool-1-thread-1正在执行...
         pool-1-thread-1正在执行...
         */
    }

    @Test
    public void testFixThreadExecutorPool() {
        //创建一个可重用固定线程数的线程池
        ExecutorService pool = Executors.newFixedThreadPool(2);

        //创建实现了Runnable接口对象，Thread对象当然也实现了Runnable接口
        Thread t1 = new MyThread();
        Thread t2 = new MyThread();
        Thread t3 = new MyThread();
        Thread t4 = new MyThread();
        Thread t5 = new MyThread();

        //将线程放入池中进行执行
        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        pool.execute(t4);
        pool.execute(t5);

        //关闭线程池
        pool.shutdown();
        /*
         *pool-1-thread-1正在执行...
         *pool-1-thread-2正在执行...
         *pool-1-thread-1正在执行...
         *pool-1-thread-2正在执行...
         *pool-1-thread-1正在执行...
         */
    }

    @Test
    public void testCachedThreadExecutorPool() {
        //创建一个可重用固定线程数的线程池
        ExecutorService pool = Executors.newCachedThreadPool();

        //创建实现了Runnable接口对象，Thread对象当然也实现了Runnable接口
        Thread t1 = new MyThread();
        Thread t2 = new MyThread();
        Thread t3 = new MyThread();
        Thread t4 = new MyThread();
        Thread t5 = new MyThread();

        //将线程放入池中进行执行
        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        pool.execute(t4);
        pool.execute(t5);

        //关闭线程池
        pool.shutdown();
        /*
         pool-1-thread-1正在执行...
         pool-1-thread-2正在执行...
         pool-1-thread-1正在执行...
         pool-1-thread-3正在执行...
         pool-1-thread-1正在执行...
         */
    }

    @Test
    public void testScheduledThreadPoolExecutor() {
        ScheduledThreadPoolExecutor exec = new ScheduledThreadPoolExecutor(1);

        exec.scheduleAtFixedRate(new Runnable() {//每隔一段时间就触发异常
            public void run() {
                System.out.println("================");
            }
        }, 1000, 5000, TimeUnit.MILLISECONDS);

        exec.scheduleAtFixedRate(new Runnable() {//每隔一段时间打印系统时间，证明两者是互不影响的
            public void run() {
                System.out.println(System.nanoTime());
            }
        }, 1000, 2000, TimeUnit.MILLISECONDS);
    }
    /**
     ================
     440697961331385
     440699965178923
     440701962726589
     ================
     440703964380898
     440705963957505
     ================
     440707961439581
     440709966042376
     440711964335904
     ================
     */
}
