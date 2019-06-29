package com.hust.concurrent.Lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 用来测试读源码，走流程
 */
public class ReentrantLockDemo {

    private int i=0;
    private ReentrantLock reentrantLock=new ReentrantLock();
    public void inCreate(){
        reentrantLock.lock();
        try {
            i++;
            System.out.println(i);
        }finally {
            reentrantLock.unlock();//往往就是这么写，当try里面执行的操作可能会抛出异常而结束的时候，就调用finally方法释放锁
        }
    }


    public static void main(String[] args) {
     ReentrantLockDemo  reentrantLockDemo = new ReentrantLockDemo();
        for (int i = 0; i < 3 ; i++) {
//            new Thread(()->{
//               new ReentrantLockDemo().inCreate();//这里会创建3个ReentrantLockDemo对象，并且每个对象也有不同的reentrantLock对象
//            }).start();

            new Thread(()-> reentrantLockDemo.inCreate()).start();

        }


    }

}
