package com.hust.concurrent.communication.demo1;

import java.io.*;

/**
 * @author Created by Divo
 * @date 2019/6/29
 */
public class Main {
    public static void main(String[] args) throws IOException {
        PipedInputStream pipedInputStream=new PipedInputStream();
        PipedOutputStream pipedOutputStream=new PipedOutputStream();
        pipedOutputStream.connect(pipedInputStream);

        new Thread(new Reader(pipedInputStream)).start();

        BufferedReader bufferedReader=null;
        try {
            bufferedReader=new BufferedReader(new InputStreamReader(System.in));
            pipedOutputStream.write(bufferedReader.readLine().getBytes());
        }finally {
            pipedOutputStream.close();
            if (bufferedReader != null) {
              bufferedReader.close();
            }
        }

    }
}
