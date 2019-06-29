package com.hust.concurrent.Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Created by Divo
 * @date 2019/6/29
 *  锁降级
 *  应用场景: 用于对数据比较敏感，需要在对数据修改之后，获取到修改后的值，并进行接下来的其他操作
 */
public class LockDegradeDemo {
     private int i=0;
     private ReadWriteLock readWriteLock=new ReentrantReadWriteLock();
     private Lock readlock=readWriteLock.readLock();
     private Lock writelock=readWriteLock.writeLock();

      public void doSomething(){
          writelock.lock();
          try {
              i++;
              readlock.lock();//已经获取读锁，所以下一个线程必须等待这个线程（与前面的线程不同）把读锁给释放掉才能获取写锁
                               //从源代码可以看到，当前线程获取了写所以后可以获取读锁
                                //写写互斥、读写互斥、读读共享（对于不同的线程）
          }finally {
              writelock.unlock();
          }

          try {
              Thread.sleep(2000L);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }

          try {
              if (i == 1) {
                  System.out.println("i的值为-------->1");
              }else {
                  System.out.println("i的值为------->"+i);
              }
          }finally {
              readlock.unlock();
          }
      }

    public static void main(String[] args) {
        LockDegradeDemo lockDegradeDemo=new LockDegradeDemo();
        for (int j = 0; j <4 ; j++) {
          new Thread(()-> lockDegradeDemo.doSomething()).start();
        }
    }
}
