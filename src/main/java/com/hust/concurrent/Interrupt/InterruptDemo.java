package com.hust.concurrent.Interrupt;

/**
 * 需要对比别的代码  P93页
 */
public class InterruptDemo implements  Runnable{


    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread=new Thread(new InterruptDemo(),"AAA");
        thread.start();
        Thread.sleep(1000L);
        thread.interrupt();
    }
}
