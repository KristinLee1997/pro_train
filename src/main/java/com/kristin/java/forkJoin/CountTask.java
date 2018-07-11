package com.kristin.java.forkJoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * @author hang li
 * @since 2018/5/14
 * 使用Fork/Join框架,计算1+2+3+4
 */
public class CountTask extends RecursiveTask<Integer> {
    private static final int THRESHOLD = 2;  //阈值

    private int start;
    private int end;

    public CountTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public static void testFork(int start, int end) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        //生成一个计算任务 1+2+3+4
        CountTask countTask = new CountTask(start, end);

        //执行一个任务
        Future<Integer> result = forkJoinPool.submit(countTask);

        try {
            System.out.println(result.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static void testSum(int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += i;
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        int start = 1;
        int end = 1000000;
        long forkTime = System.currentTimeMillis();
        testFork(start, end);
        System.out.println("fork time: " + (System.currentTimeMillis() - forkTime));
        long sumTime = System.currentTimeMillis();
        testSum(start, end);
        System.out.println("sum time: " + (System.currentTimeMillis() - sumTime));
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        //如果任务足够小,就直接计算任务
        boolean canCompute = (end - start) <= THRESHOLD;
        if (canCompute) {
            for (int i = start; i <= end; i++) {
                sum += i;
            }
        } else {
            //如果任务大于阈值,就fork为两个子任务进行计算
            int middle = (start + end) / 2;
            CountTask leftTask = new CountTask(start, middle);
            CountTask rightTask = new CountTask(middle + 1, end);

            //执行两个子任务
            leftTask.fork();
            rightTask.fork();

            //等待两个子任务执行,并返回执行结果
            int leftResult = leftTask.join();
            int rightResult = rightTask.join();

            sum = leftResult + rightResult;
        }
        return sum;
    }
}
