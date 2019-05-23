package com.hust.concurrent.Interrupt;

/**
 * 用过标识位来动态改变  P95
 */
public class Shutdown {

        private static class Runner implements Runnable{
            long i=0;
           private volatile boolean on=true;


            @Override
            public void run() {
                while (on && !Thread.currentThread().isInterrupted()){
                    i++;
                }
                System.out.println("Count i= "+i);
            }

            public void cancel(){
                on= false;
            }
        }

    public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread(new Runner(),"CountThread");
        t1.start();
        Thread.sleep(1000L);//主线程睡眠一秒钟，主线程对t1进行中断，使t1能感知到中断而结束
        t1.interrupt();


        Runner Two=new Runner();
        Thread t2=new Thread(Two,"CountThread");
        t2.start();
        Thread.sleep(1000L);
        Two.cancel();

    }

}
