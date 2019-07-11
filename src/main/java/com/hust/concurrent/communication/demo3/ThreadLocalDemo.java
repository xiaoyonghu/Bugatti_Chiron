package com.hust.concurrent.communication.demo3;

/**
 * @author Created by Divo
 * @date 2019/6/29
 */
public class ThreadLocalDemo {

    //为每个线程单独存放一份变量副本，也就是说一个线程可以根据一个ThreadLocal对象查询到绑定在这个线程上的一个值
    ThreadLocal<Integer> num=ThreadLocal.withInitial(()->0);

    public void inCreate(){
        Integer myNum=num.get();
        myNum++;
        System.out.println(Thread.currentThread().getName()+"------>"+myNum);
        num.set(myNum);

    }

    public static void main(String[] args) {
        ThreadLocalDemo threadLocalDemo = new ThreadLocalDemo();
        for (int i = 1; i < 3; i++) {
            int finalI = i;
            new Thread(()->{
                while (true){
                    threadLocalDemo.inCreate();
                    try {
                        Thread.sleep(finalI *1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
