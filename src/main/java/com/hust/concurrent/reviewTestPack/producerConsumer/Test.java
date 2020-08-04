package com.hust.concurrent.reviewTestPack.producerConsumer;

/**
 * @author Created by Divo
 * @date 2020/8/4
 * Description:用来组合生产者和消费者
 * Status:finished
 */
public class Test {
    public static void main(String[] args) {
        Container container = new Container(5);
        Thread producer1 = new Thread(new producer(container));
        Thread producer2 = new Thread(new producer(container));
        Thread producer3 = new Thread(new producer(container));
        Thread producer4 = new Thread(new producer(container));
        Thread producer5 = new Thread(new consumer(container));
        Thread consumer1 = new Thread(new consumer(container));
        Thread consumer2 = new Thread(new consumer(container));
        producer1.start();
        producer2.start();
        producer3.start();
        producer4.start();
        producer5.start();
        consumer1.start();
        consumer2.start();
    }
}
