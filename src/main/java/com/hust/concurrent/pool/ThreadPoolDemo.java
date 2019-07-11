package com.hust.concurrent.pool;

import java.util.concurrent.*;

/**
 * @author Created by Divo
 * @date 2019/7/1
 * 测试ThreadPool的使用，书本上有明确介绍，那个参数的取舍与queue的选取相关
 */
public class ThreadPoolDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        LinkedBlockingQueue<Runnable> runnableLinkedBlockingQueue = new LinkedBlockingQueue<>(20);//直接看源码或者书都行

//        for (int i = 0; i < 50; i++) {
//            runnableLinkedBlockingQueue.put(
//                    ()->{
//                        System.out.println(Thread.currentThread().getName());
//                    }
//            );
//        }

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20, 3L, TimeUnit.SECONDS, runnableLinkedBlockingQueue,new CustomPolicy());
        threadPoolExecutor.prestartAllCoreThreads();//提前开启核心数个线程，用来处理任务

        for (int i = 0; i < 50; i++) {
          threadPoolExecutor.submit(()->{
              try {
                  Thread.sleep(2000L);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
              System.out.println(threadPoolExecutor.getActiveCount());
          });
        }

        //        Future<String> submit=null;
//        for (int i = 0; i < 50; i++) {
//
//         submit =  threadPoolExecutor.submit(new CallableDemo());
//        }
//        for (int j = 0; j < 50; j++) {
//            System.out.println(submit.get());
//        }
    }
}
