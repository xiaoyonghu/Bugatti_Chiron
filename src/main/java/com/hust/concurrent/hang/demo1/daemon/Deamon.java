package com.hust.concurrent.hang.demo1.daemon;

import com.hust.concurrent.hang.demo1.DeadDemo;

import java.util.concurrent.TimeUnit;

public class Deamon implements Runnable{


    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(300L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println("DaemonThread finally run");//不会执行
        }
    }

    public static void main(String[] args) {
        Thread t1=new Thread(new Deamon(),"Divo");
        t1.setDaemon(true);
        t1.start();
    }
}
