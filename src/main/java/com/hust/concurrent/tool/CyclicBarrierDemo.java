package com.hust.concurrent.tool;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author Created by Divo
 * @date 2019/7/1
 * 用来模拟一下CyclicBarrier的简单使用
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(8);
        for (int i = 0; i < 8; i++) {
            int finalI = i;
            new Thread(()->{
                try {
                    Thread.sleep(finalI *1000l);
                    System.out.println(Thread.currentThread().getName()+":准备就绪");
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println("开始比赛");
            }).start();
        }
    }
}
