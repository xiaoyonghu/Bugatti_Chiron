package com.hust.concurrent.pool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Created by Divo
 * @date 2019/7/2
 */
public class OMMdemo2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 100; i++) {
            Future<Integer> submit = executorService.submit(() -> {
                System.out.println(Thread.currentThread().getName());
                return 1 / 0;
            });
        submit.get();
        }

    }
}
