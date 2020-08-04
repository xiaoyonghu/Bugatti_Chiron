package com.hust.concurrent.reviewTestPack.producerConsumer;

/**
 * @author Created by Divo
 * @date 2020/8/4
 * Description:消费者
 * Status:finished
 */
public class consumer implements Runnable{
    private Container container;
    public consumer(Container container) {
        this.container = container;}
    @Override
    public void run() {
        while (true){
            Integer val = container.take();
        }
    }
}
