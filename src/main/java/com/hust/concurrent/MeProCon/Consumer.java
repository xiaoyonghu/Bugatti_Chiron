package com.hust.concurrent.MeProCon;

/**
 * @author Created by Divo
 * @date 2019/6/29
 * 消费者
 */
public class Consumer implements Runnable{

    //此时的medium要一样，同一个对象
    private Medium medium;

    public Consumer(Medium medium){
        this.medium=medium;
    }
    @Override
    public void run() {
        while (true){
            medium.take();
        }
    }
}
