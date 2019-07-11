package com.hust.concurrent.tool;

import java.util.concurrent.Exchanger;

/**
 * @author Created by Divo
 * @date 2019/7/1
 * 测试exchange的用法，要求为交换数据的线程要成对
 */
public class ExchangeDemo {
    public static void main(String[] args) {
        Exchanger<String> stringExchanger = new Exchanger<>();
        String str1="Roaster";
        String str2="Divo";
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+":初始值----->"+str1);
            try {
                String exchange = stringExchanger.exchange(str1);
                System.out.println(Thread.currentThread().getName()+":交换后的值----->"+exchange);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        },"Thread-1").start();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+":初始值----->"+str2);
            try {
                String exchange1 = stringExchanger.exchange(str2);
                System.out.println(Thread.currentThread().getName()+":交换后的值----->"+exchange1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"Thread-2").start();
    }
}
