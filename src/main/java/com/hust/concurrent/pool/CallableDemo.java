package com.hust.concurrent.pool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author Created by Divo
 * @date 2019/7/2
 * 测试callable的简单使用，书本上有详细的说明
 */
public class CallableDemo implements Callable<String> {
    @Override
    public String call() throws Exception {
       Thread.sleep(3000L);
        return "1111";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableDemo callableDemo = new CallableDemo();
        FutureTask<String> stringFutureTask = new FutureTask<>(callableDemo);
        new Thread(stringFutureTask).start();
        System.out.println(stringFutureTask.get());
    }
}
