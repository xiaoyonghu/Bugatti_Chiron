package com.hust.concurrent.pool;

import javax.swing.plaf.TableHeaderUI;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Created by Divo
 * @date 2019/7/2
 */
public class OMMdemo1 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        while (true){
            executorService.submit(()->{
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

    }
}
