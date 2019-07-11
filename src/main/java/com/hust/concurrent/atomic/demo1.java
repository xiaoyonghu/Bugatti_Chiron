package com.hust.concurrent.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Created by Divo
 * @date 2019/7/1
 * AtomicInteger 的使用测试
 */
public class demo1 {
    private static AtomicInteger sum=new AtomicInteger(0);
    public static void inCreate(){
        sum.incrementAndGet();

    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                for (int j = 0; j < 100; j++) {
                    inCreate();
                    System.out.println(sum);
                }
            }).start();
        }
    }

}

