package com.hust.concurrent.communication.demo1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.util.stream.Collectors;

/**
 * @author Created by Divo
 * @date 2019/6/29
 */
public class Reader implements Runnable {
  private PipedInputStream pipedInputStream;

    public Reader(PipedInputStream pipedInputStream) {
        this.pipedInputStream = pipedInputStream;
    }

    @Override
    public void run() {
    if(pipedInputStream != null){
        String collect = new BufferedReader(new InputStreamReader(pipedInputStream)).lines().collect(Collectors.joining("\n"));
        System.out.println("当前输入的值为----->"+collect);
    }
        try {
            pipedInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
