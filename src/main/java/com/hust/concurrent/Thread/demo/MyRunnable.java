package com.hust.concurrent.Thread.demo;

import java.io.IOException;
import java.io.Serializable;

public class MyRunnable implements Runnable, Serializable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());

        //主要用于等待
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Thread t1=new Thread(new MyRunnable());//传递一个Runnable对象
        t1.setName("Albert Divo");
        t1.start();
         //t1.run();
    }
}
