package com.hust.concurrent.hang.demo1;

/**
 * 测试已经废弃的suspend,resume方法
 */
public class suspend implements Runnable{


    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"执行run方法，准备调用suspend方法");
        Thread.currentThread().suspend();
        System.out.println(Thread.currentThread().getName()+"执行run方法，调用suspend方法结束");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread(new suspend(),"测试线程1");
        t1.start();
        Thread.sleep(3000);//主线程休眠
        t1.resume();

    }
}
