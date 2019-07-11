package com.hust.concurrent.communication.demo2;

/**
 * @author Created by Divo
 * @date 2019/6/29
 * 测试join方法的使用
 */
public class Join {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "开始运行");
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "运行结束");
        }, "线程1");

        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "开始运行");
            thread.start();

            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "运行结束");
        },"线程2").start();

    }
}
