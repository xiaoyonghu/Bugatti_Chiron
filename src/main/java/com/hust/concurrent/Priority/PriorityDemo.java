package com.hust.concurrent.Priority;

/**
 * 优先级测试,概率问题
 * 优先级高的线程分配时间片的数量多于低优先级的线程
 */
public class PriorityDemo {

    public static void main(String[] args) {
        Thread t1=new Thread(()->{
            while (true){
                System.out.println(Thread.currentThread().getName());
//                try {
//                    Thread.sleep(1000L);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        },"线程AAAA");

        Thread t2=new Thread(()->{
            while (true){
                System.out.println(Thread.currentThread().getName());
//                try {
//                    Thread.sleep(1000L);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        },"线程BBBB");


        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);

        t1.start();
        t2.start();

    }








    //    static class Runner implements Runnable{
//
//        @Override
//        public void run() {
//            System.out.println(Thread.currentThread().getName());
//        }
//    }

}
