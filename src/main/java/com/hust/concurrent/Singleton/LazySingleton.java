package com.hust.concurrent.Singleton;

/**
 *  懒汉式单例
 *  在需要的时候再实例化
 *  double check实现线程安全
 */
public class LazySingleton {

    //volatile 关键字其中的一个作用是: 修饰对象实例，禁止指令重排序
    private  static volatile LazySingleton lazySingleton=null;

  private LazySingleton(){
  }

   // private static synchronized LazySingleton getInstance(){//线程安全，但是性能不行
  private static LazySingleton getInstance(){
      //判断是否为空，如果为空则实例化
      if(lazySingleton == null){
          //模拟实例化耗时
//          try {
//              Thread.sleep(1000);
//          } catch (InterruptedException e) {
//              e.printStackTrace();
//          }

          //假如第1.2线程进来就会出现2个不同的实例，简单点就是几个线程同时进来这里就有多少个不同的实例
          //如果休眠1秒钟，足够10个线程都进来
//          synchronized (LazySingleton.class){
//              lazySingleton=new LazySingleton();
//          }

          synchronized (LazySingleton.class){
              if(lazySingleton == null){
                  lazySingleton=new LazySingleton();
              }
          }
      }
      return lazySingleton;
  }

    public static void main(String[] args) {
        for (int i = 0; i <10 ; i++) {
            new Thread(()->{
                System.out.println(LazySingleton.getInstance());
            }).start();
        }
    }

}
