package com.hust.concurrent.container;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Created by Divo
 * @date 2019/7/1
 */
public class LinkedBlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue<String> strings = new LinkedBlockingQueue<>();
       //说实话没必要，只需要用的时候学习一下即可
        //放元素
        strings.add("111");
        strings.offer("111");
        strings.put("111");

        //取元素
        String remove = strings.remove();
        strings.poll();
        strings.take();
    }
}
