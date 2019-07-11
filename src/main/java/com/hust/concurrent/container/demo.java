package com.hust.concurrent.container;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Created by Divo
 * @date 2019/7/1
 */
public class demo {
    public static void main(String[] args) {
        ArrayList<String> stringArrayList = new ArrayList<>();
        List<String> stringList = Collections.synchronizedList(stringArrayList);
    }
}
