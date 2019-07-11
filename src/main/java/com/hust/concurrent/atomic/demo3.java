package com.hust.concurrent.atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @author Created by Divo
 * @date 2019/7/1
 * AtomicIntegerArray 的使用用例
 * JUC -- java util concurrent
 */
public class demo3 {
    public static void main(String[] args) {
        int[] arr=new int[]{3,2};
         AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(arr);
        System.out.println(atomicIntegerArray.addAndGet(1, 3));

        int i = atomicIntegerArray.accumulateAndGet(0, 2, (left, right) ->
                left > right ? left : right);
        System.out.println(i);
    }
}
