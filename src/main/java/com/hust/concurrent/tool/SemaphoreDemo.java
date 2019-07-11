package com.hust.concurrent.tool;

import java.util.concurrent.Semaphore;

/**
 * @author Created by Divo
 * @date 2019/7/1
 * Semaphore的使用用例:控制并发数量
 * 使用场景：接口限流
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);

        //同一时刻只有3个能进行操作
        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();//需要先获取才能执行
                    System.out.println(Thread.currentThread().getName()+":开始执行");
                    Thread.sleep(5000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            }).start();
        }
    }
}
