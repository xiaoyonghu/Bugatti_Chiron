package com.hust.concurrent.reviewTestPack.producerConsumer;

import java.util.Random;

/**
 * @author Created by Divo
 * @date 2020/8/4
 * Description:生产者
 * Status:finished
 */
public class producer implements Runnable{
    private Container container;

    public producer(Container container){
        this.container = container;
    }
    @Override
    public void run() {
        while (true)
            container.put(new Random().nextInt(100));
    }
}
