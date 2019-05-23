package com.hust.concurrent.hang.demo1.daemon;

public class DaemonDemo implements Runnable {
    @Override
    public void run() {
       while (true){
           System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       }

    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread=new Thread(new DaemonDemo(),"DaemonDemo线程");
        thread.setDaemon(true);
        thread.start();
        Thread.sleep(2000L);//主线程休眠
    }
}
