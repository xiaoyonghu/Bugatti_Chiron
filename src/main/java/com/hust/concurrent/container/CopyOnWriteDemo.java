package com.hust.concurrent.container;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Created by Divo
 * @date 2019/7/1
 */
public class CopyOnWriteDemo {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> strings = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 1000; i++) {
            strings.add("demo" + i);
        }
        for (int j = 0; j < 4; j++) {
            new Thread(() -> strings.forEach(s -> {
                if (s.equals("demo2")) {
                    strings.remove(s);
                }
            })).start();
        }
    }


}
