package com.hust.concurrent.Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ReentrantReadWriteLockDemo
 * 用来测试，读写锁的互斥性
 */
public class ReentrantReadWriteLockDemo {

    private int i = 0;
    private int j = 0;

    private ReadWriteLock lock = new ReentrantReadWriteLock();
    Lock readLock = lock.readLock();
    Lock writeLock = lock.writeLock();

    public void out(){
        readLock.lock();//断点
        try {
            System.out.println(Thread.currentThread().getName()+"i的值====》"+i + "j的值====》"+j);
        }finally {
            readLock.unlock();
        }

    }

    public void inCreate() {
        writeLock.lock();//断点

        try {
            i++;
            Thread.sleep(500L);
            j++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            writeLock.unlock();
        }

    }

    public static void main(String[] args) {
        ReentrantReadWriteLockDemo reentrantReadWriteLockDemo = new ReentrantReadWriteLockDemo();
//        for (int i = 0; i < 3; i++) {
//            new Thread(()->{
//                reentrantReadWriteLockDemo.inCreate();
//                reentrantReadWriteLockDemo.out();
//            }).start();
//        }

        new Thread(()->{
            reentrantReadWriteLockDemo.out();
        },"读线程").start();
        new Thread(()->{
            reentrantReadWriteLockDemo.inCreate();
        },"写线程").start();

//        new Thread(()->{
//            reentrantReadWriteLockDemo.out();
//        },"读线程1").start();
//        new Thread(()->{
//            reentrantReadWriteLockDemo.out();
//        },"读线程2").start();
      }
    }
