package com.hust.concurrent.hang.demo1;

public class DeadDemo implements Runnable {

   private static Object object=new Object();

   @Override
    public void run() {
     synchronized (object){
         System.out.println(Thread.currentThread().getName()+"占有资源");
         Thread.currentThread().suspend();
     }
       System.out.println(Thread.currentThread().getName()+"释放占有资源");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread(new DeadDemo(),"对比线程");
        t1.start();
        Thread.sleep(1000);
        t1.resume();

        Thread t2=new Thread(new DeadDemo(),"死锁线程");
        t2.start();
        t2.resume();

    }
}
