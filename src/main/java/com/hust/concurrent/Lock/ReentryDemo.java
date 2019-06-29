package com.hust.concurrent.Lock;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Lock;

/**
 *用来测试 Mylock 重入锁
 */
public class ReentryDemo {
  private Lock lock=new MyLock();


  public void methodA(){
      lock.lock();
      System.out.println("加入A方法");
      methodB();
      lock.unlock();
  }

    public void methodB(){
        lock.lock();
        System.out.println("加入B方法");
        lock.unlock();
    }

    public static void main(String[] args) {
        ReentryDemo reentryDemo=new ReentryDemo();
        reentryDemo.methodA();
    }
}
