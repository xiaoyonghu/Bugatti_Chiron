package com.hust.concurrent.sysopsis;

import java.util.concurrent.CountDownLatch;

public class UnsafeThread {
    private  static int num=0;
    private static CountDownLatch countDownLatch=new CountDownLatch(10);

    //1.方法加上synchronized
    //2.用java提供的原子包
    public static synchronized void inCrease(){
        num++;
    }

    public static void main(String[] args) {
        for (int i = 0; i <10 ; i++) {
            new Thread(()->{
                for (int j = 0; j <100 ; j++) {
                    inCrease();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                countDownLatch.countDown();//decrease the number of N when a thread finish the process of run() method
            }

            ).start();
        }

        try {
            countDownLatch.await();//the main thread can't run until  all thread to finish
            System.out.println(num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
