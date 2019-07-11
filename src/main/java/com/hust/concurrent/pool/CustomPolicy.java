package com.hust.concurrent.pool;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author Created by Divo
 * @date 2019/7/2
 */
public class CustomPolicy implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        //可以自定义一些告警，即通过第三方的工具进行发短信什么的
        System.out.println("线程池满了");
    }
}
