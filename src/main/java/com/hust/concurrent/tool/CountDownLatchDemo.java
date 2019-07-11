package com.hust.concurrent.tool;

import java.util.concurrent.CountDownLatch;

/**
 * @author Created by Divo
 * @date 2019/7/1
 * 只是用来模拟一下countdownlatch的使用
 */
public class CountDownLatchDemo {
    public static void main(String[] args) {
        CountDownLatch countDownLatch= new CountDownLatch(8);
        new Thread(()->{
            try {
                countDownLatch.await(); //等到8变为0即可，接着运行下面的代码
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("800米比赛结束，准备清空跑道并继续跨栏比赛");
        }).start();


        for (int i = 0; i < 8; i++) {
            int finalI = i;
            new Thread(()->{
                try {
                    Thread.sleep(finalI *1000L);
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    countDownLatch.countDown();
                }
            }).start();

        }
    }
}
