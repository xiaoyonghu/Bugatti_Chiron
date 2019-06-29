package com.hust.concurrent.Lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class MyLock implements Lock {


    private boolean isHoldLock=false;
    private Thread holdLockThread=null;
    private int reentryCount = 0;

    /**
     * 同一时刻，能且仅能有一个线程获取到锁
     */
    @Override
    public synchronized void lock() {
        //需要等待锁的情况  -->锁被锁住,并且持有锁的线程不是当前线程
        if(isHoldLock && (Thread.currentThread() != holdLockThread)){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        holdLockThread=Thread.currentThread();
        isHoldLock=true;
        reentryCount++;
    }


    @Override
    public synchronized void unlock() {

        //判断当前的线程是否是持有锁的线程
        // 是的话,重入次数减1，不是就啥也不用干
        if(Thread.currentThread() == holdLockThread){
           reentryCount--;
           if(reentryCount == 0){
               //通知别的等待此锁的线程
               notify();
               isHoldLock=false;
           }
       }


    }

    @Override
    public Condition newCondition() {
        return null;
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

}
