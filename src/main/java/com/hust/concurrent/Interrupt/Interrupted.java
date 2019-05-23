package com.hust.concurrent.Interrupt;

import java.util.concurrent.TimeUnit;

public class Interrupted {

  static class SleepRunner implements Runnable{

      @Override
      public void run() {
          while (true){
              try {
                  TimeUnit.SECONDS.sleep(1000L);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
          }
      }
  }

  static class BusyRunner implements Runnable{

      @Override
      public void run() {
          while (true){
          }
      }
  }

    public static void main(String[] args) throws InterruptedException {
        Thread sleepThread =new Thread(new SleepRunner(),"SleepThread");
        sleepThread.setDaemon(true);

        Thread busyThread =new Thread(new BusyRunner(),"busyThread");
        busyThread.setDaemon(true);

        sleepThread.start();
        busyThread.start();

        Thread.sleep(5000L);

        sleepThread.interrupt();
        busyThread.interrupt();

        System.out.println("SleepThread is "+sleepThread.isInterrupted());   //SleepThread is false.抛出InterruptedException的线程，中断标志位被清除
        System.out.println("busyThread is "+busyThread.isInterrupted());    //busyThread is true

        Thread.sleep(2000L);



    }


}
