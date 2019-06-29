package com.hust.concurrent.hang.demo1;

/**
 * 通过wait，notify来改进suspend和resume方法
 */
public class WaitDemo implements Runnable{

    private static Object object=new Object(); //一个对象可以有多个相关的条件锁，
                                               // 并且每个条件锁有一个可持有数(用来统计某一条件锁的持有数)
    @Override
    public void run() {
        synchronized (object){
            System.out.println(Thread.currentThread().getName()+"占有资源");
            try {
                //某一条件不满足
                object.wait();//等待某一条件
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+"释放占有资源");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread(new WaitDemo(),"AAA");
        t1.start();

        Thread t2=new Thread(new WaitDemo(),"BBB");
        t2.start();
        Thread.sleep(3000L);

        //必须要先锁住，才能应用对象或者对象条件上的notify.notifyall方法
        synchronized (object){//如果主线程有休眠时间的话，足以给上面2个线程释放相应对象锁的时间
            //object.notify();   //随机通知在队列中等待此条件的一个线程
            object.notifyAll();   //通知队列中等待此条件的所有线程
        }

    }
}
