package com.hust.concurrent.Interrupt;

public class MyInterrupt implements Runnable {

   private static volatile boolean Flg=true;
    @Override
    public void run() {
        while (Flg){
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread=new Thread(new MyInterrupt(),"BBBB");
        thread.start();
        Thread.sleep(100);//睡眠1秒，main线程对thread的标识位进行改变，使CountThread能够感知Flg为false而结束
        Flg=false;//用来模拟对标识位的改变
    }


}
