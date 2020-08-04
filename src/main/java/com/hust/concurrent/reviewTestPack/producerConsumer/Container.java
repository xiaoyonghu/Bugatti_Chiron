package com.hust.concurrent.reviewTestPack.producerConsumer;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Created by Divo
 * @date 2020/8/4
 * Description: 容器
 * Status:finished
 */
public class Container {
    private final Lock lock = new ReentrantLock();
    //表示生产者线程
    private final Condition notFull = lock.newCondition();
    //表示消费者线程
    private final Condition notEmpty = lock.newCondition();
    private int capacity;
    private List<Integer> list = new LinkedList<>();

    //可以通过构造行数传入容量
    Container(int capacity) {
        this.capacity = capacity;
    }

    public Integer take() {
        lock.lock();
        try {
            while (list.size() == 0)
                try {
                    //System.out.println("the list is empty........");
                    notEmpty.await();//阻塞消费者线程
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            Integer val = list.remove(0);
            System.out.println("consumer--" + Thread.currentThread().getName() + "--take:" + val + "===size:" + list.size());
            notFull.signalAll();//唤醒所有生产者线程
            return val;
        } finally {
            lock.unlock();
        }
    }

    public void put(Integer val) {
        lock.lock();
        try {
            while (list.size() == capacity) {
                try {
                    //System.out.println("the list is full........");
                    notFull.await();//阻塞生产者线程
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.add(val);
            System.out.println("producer--" + Thread.currentThread().getName() + "--put:" + val + "===size:" + list.size());
            notEmpty.signalAll();//唤醒所有消费者线程
        } finally {
            lock.unlock();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
