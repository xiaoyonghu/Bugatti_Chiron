package com.hust.concurrent.communication.demo4;

/**
 * @author Created by Divo
 * @date 2019/6/29
 * 生产者
 */
public class Producer implements Runnable {
    private Medium medium;

    public Producer(Medium medium) {
        this.medium = medium;
    }

    @Override
    public void run() {
        while (true){
            medium.put();//生产消息即可
        }
    }
}
