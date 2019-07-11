package com.hust.concurrent.communication.demo4;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Created by Divo
 * @date 2019/6/29
 * 测试lock condition 的用法
 */
public class Medium {
    private int sum=0;
    private static final int TOTAL=20;
    private Lock lock=new ReentrantLock();
    private Condition consumerCondition=lock.newCondition();
    private Condition producerCondition=lock.newCondition();


    /**
     * 对于生产者来说，放入数据
     */
    public void put(){
          lock.lock();
           try {
               //判断当前的库存，是否已经达到了最大值
               if (sum<TOTAL){
                   //如果不是，先进行生产，然后通知消费者进行消费
                   System.out.println("增加库存-->当前的库存为"+ (++sum));
                   try {
                       Thread.sleep(2000L);//模拟生产耗时2秒
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                   consumerCondition.signalAll();//通知所有的等待线程
               }else{
                   //如果是，通知生产者进行等待
                   try {
                       System.out.println("库存已满---->当前的库存为"+sum);
                      producerCondition.await();//生产者进行等待
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
           }finally {
              lock.unlock();
           }


    }

    /**
     * 对于消费者来说，消费数据
     */
    public synchronized void take(){
        lock.lock();
        try {
            //判断当前的库存是否不足
            if (sum>0){
                //如果充足，在消费完成后通知生产者进行生产
                System.out.println("消费库存---->当前的库存为"+(--sum));
                try {
                    Thread.sleep(2000L); //模拟消费耗时2秒
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                producerCondition.signalAll();
            }else {
                //如果不足，通知消费者进行等待
                System.out.println("库存不足------>当前的库存为"+sum);
                try {
                   consumerCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }finally {
            lock.unlock();
        }

    }
}
