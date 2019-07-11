package com.hust.concurrent.pool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @author Created by Divo
 * @date 2019/7/2
 * 通过Executor创建线程池
 */
public class ExecutorDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ExecutorService executorService1 = Executors.newFixedThreadPool(2);
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        ExecutorService executorService2 = Executors.newWorkStealingPool();
        ExecutorService executorService3 = Executors.newSingleThreadExecutor();
        ScheduledExecutorService scheduledExecutorService1 = Executors.newSingleThreadScheduledExecutor();

        executorService.submit(()-> System.out.println(Thread.currentThread().getName()));


    }
}
