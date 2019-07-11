package com.hust.concurrent.atomic;

import java.util.OptionalLong;
import java.util.concurrent.atomic.LongAccumulator;

/**
 * @author Created by Divo
 * @date 2019/7/1
 * LongAccumulator 的使用用例
 */
public class demo2 {
    public static void main(String[] args) {
        //返回大数
        LongAccumulator longAccumulator=new LongAccumulator((left, right) ->
                left > right ? left : right, 3L
                );
        longAccumulator.accumulate(3L);
        System.out.println(longAccumulator.get());
        longAccumulator.accumulate(5L);
        System.out.println(longAccumulator.get());
    }
}
