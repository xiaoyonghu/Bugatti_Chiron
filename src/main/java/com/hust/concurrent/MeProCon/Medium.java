package com.hust.concurrent.MeProCon;

/**
 * @author Created by Divo
 * @date 2019/6/29
 */
public class Medium {
    private int sum=0;
    private static final int TOTAL=20;

    /**
     * 对于生产者来说，放入数据
     */
    public synchronized void put(){
           //判断当前的库存，是否已经达到了最大值
        if (sum<TOTAL){
           //如果不是，先进行生产，然后通知消费者进行消费
            System.out.println("增加库存-->当前的看库存为"+ (++sum));
            notifyAll(); //通知所有的等待线程
        }else{
            //如果是，通知生产者进行等待
            try {
                System.out.println("库存已满---->当前的库存为"+sum);
                wait();//生产者进行等待
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 对于消费者来说，消费数据
     */
    public synchronized void take(){
        //判断当前的库存是否不足
        if (sum>0){
            //如果充足，在消费完成后通知生产者进行生产
            System.out.println("消费库存---->当前的库存为"+(--sum));
            notifyAll();
        }else {
            //如果不足，通知消费者进行等待
            System.out.println("库存不足------>当前的库存为"+sum);
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
