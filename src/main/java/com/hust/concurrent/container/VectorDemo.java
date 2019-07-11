package com.hust.concurrent.container;

import java.util.Iterator;
import java.util.Vector;

/**
 * @author Created by Divo
 * @date 2019/7/1
 * 用来测试Vector 的使用方法
 */
public class VectorDemo {
    public static void main(String[] args) {
        Vector<String> stringVector = new Vector<>();
        for (int i = 0; i < 1000; i++) {
          stringVector.add("demo"+i);
        }

        Iterator<String> stringIterator = stringVector.iterator();
        for (int j = 0; j < 4; j++) {
            new Thread(()->{
                synchronized (stringIterator){
                    while (stringIterator.hasNext()){
                        String next = stringIterator.next();
                           if (next.equals("demo2")){
                               stringIterator.remove();//删除调用stringIterator.next()方法返回的next
                           }
                    }
                }
            }).start();
        }

    }
}
