package com.hust.concurrent.Thread.demo;

//import java.util.concurrent.TimeUnit;

public class ThreadState {
     static class Timewaiting implements Runnable{


         @Override
         public void run() {
             while(true){
                // TimeUnit.SECONDS.sleep(10);
                 try {
                     Thread.sleep(1000);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }
         }
     }

    static class Waiting implements Runnable{


        @Override
        public void run() {
            while(true){
                 synchronized (Waiting.class){
                     try {
                         Waiting.class.wait();
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                 }

            }
        }
    }

    static class Blocked implements Runnable{


        @Override
        public void run() {
            while(true){
                synchronized (Blocked.class){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }

    public static void main(String[] args) {
         new Thread(new Timewaiting(),"TimeWaiting Thread").start();
         new Thread(new Waiting(),"WaitingThread").start();
         new Thread(new Blocked(),"Blocked1_1").start();
         new Thread(new Blocked(),"Blocked2_2").start();
    }

}
