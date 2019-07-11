package com.hust.concurrent.communication.demo4;

/**
 * @author Created by Divo
 * @date 2019/6/29
 */
public class Main {
        public static void main(String[] args) {
        Medium medium = new Medium();

        //模拟多个消费者
        new Thread(new Consumer(medium)).start();
        new Thread(new Consumer(medium)).start();
        new Thread(new Consumer(medium)).start();

        new Thread(new Producer(medium)).start();
        new Thread(new Producer(medium)).start();
        new Thread(new Producer(medium)).start();
        new Thread(new Producer(medium)).start();
        new Thread(new Producer(medium)).start();


    }
}
