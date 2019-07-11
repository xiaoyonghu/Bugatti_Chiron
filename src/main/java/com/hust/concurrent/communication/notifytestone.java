package com.hust.concurrent.communication;

/**
 * @author Created by Divo
 * @date 2019/6/29
 * 用来测试notify -->唤醒条件等待队列里面的一个  随机
 * notifyAll  -->  唤醒条件等待队列里面的所有
 */
public class notifytestone {
   private static volatile boolean flag=false;

    public static void main(String[] args) {
        //这里只是简单的测试
        Object obj=new Object();

        new Thread(()->{
            while (!flag){
               synchronized (obj){
                   try {
                       System.out.println("Flag is false");
                       obj.wait();
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
            }
            System.out.println("Flag is true");
        }).start();

        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            flag=true;
            synchronized (obj){
               // obj.notify();
              obj.notifyAll();
            }
        }).start();

    }

}
