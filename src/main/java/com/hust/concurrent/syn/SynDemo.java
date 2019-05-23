package com.hust.concurrent.syn;

/**     synchronized修饰的具体体现
 *    	修饰普通方法：锁住对象的实例
 *     	修饰静态方法：锁住整个类
 *     	修饰代码块： 锁住一个对象 synchronized (lock) 即synchronized后面括号里的内容
 *     	直接从字面上去理解
 */
public class SynDemo {


    //修饰普通方法：锁住对象的实例
    @SuppressWarnings("AlibabaCommentsMustBeJavadocFormat")
    public synchronized void out() throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        Thread.sleep(5000L);
    }



    //	修饰静态方法：锁住整个类
//    public static synchronized void staticOut() throws InterruptedException {
//        System.out.println(Thread.currentThread().getName());
//        Thread.sleep(5000L);
//    }


    //修饰代码块： 锁住一个对象 synchronized (lock) 即synchronized后面括号里的内容
//    private Object lock = new Object();
//    public void myOut() throws InterruptedException {
//        synchronized (lock){
//            System.out.println(Thread.currentThread().getName());
//            Thread.sleep(5000L);
//        }
//    }

    public static void main(String[] args) {
        SynDemo synDemo1=new SynDemo();
        SynDemo synDemo2=new SynDemo();
        new Thread(()->{
            try {
                synDemo1.out();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"Thread-1").start();


        new Thread(()->{
            try {
                synDemo2.out();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"Thread-2").start();

    }
}
