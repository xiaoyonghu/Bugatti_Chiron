package com.hust.concurrent.Singleton;

/**
 * 饿汉式--本身线程安全
 * 在类加载的时候，就已经进行实例化，无论之后用不用到。如果该类比较占内存，之后又没用到，就白白浪费了资源
 */
public class HungerSingleton {
    private static HungerSingleton ourInstance = new HungerSingleton();

    public static HungerSingleton getInstance() {
        return ourInstance;
    }

    //构造方法必须私有化
    private HungerSingleton() {
    }

    public static void main(String[] args) {
        for (int i = 0; i <10 ; i++) {
          new Thread(() -> {
              System.out.println(HungerSingleton.getInstance());
          }).start();
        }
    }


}
