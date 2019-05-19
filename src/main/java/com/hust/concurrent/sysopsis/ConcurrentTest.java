package com.hust.concurrent.sysopsis;

public class ConcurrentTest<main> {
    private static final long count = 100001;
    private static void concurrency() throws InterruptedException {
        long start=System.currentTimeMillis();
//        new Thread(
//                ()->{
//                   int a=0;
//                   for (long i=1;i<count;i++){
//                       a += 5;
//                   }
//                }
//        ).start();
        Thread thread=new Thread(()->
        {
                int  a=0;
                for (long i=1;i<count;i++){
                    a += 5;
                }
        }
        );
        thread.start();

        int b=0;
        for (int i = 0; i <count; i++) {
            b--;
        }

        thread.join();//terminate the specific thread
        long time=System.currentTimeMillis()-start;//calculate the time of both thread
        System.out.println("concurrency:" +time+"ms,b="+b);
    }

    private static void serial(){
        long start=System.currentTimeMillis();
        int a=0;
        for (int i = 0; i <count; i++) {
            a--;
        }

        int b=0;
        for (int i = 0; i <count; i++) {
            b--;
        }
        long time=System.currentTimeMillis()-start;
        System.out.println("serial:" +time+"ms,a="+a+",b="+b);
    }

    public static void main(String[] args) throws InterruptedException {
        concurrency();
        serial();
    }

}
