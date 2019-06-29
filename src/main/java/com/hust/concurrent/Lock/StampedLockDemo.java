package com.hust.concurrent.Lock;

import java.util.concurrent.locks.StampedLock;

/**
 * @author Created by Divo
 * @date 2019/6/29
 * 测试邮票锁的用法
 */
public class StampedLockDemo {
   //成员变量
    private double x,y;

    //锁实例
    private final StampedLock s1=new StampedLock();

    //排它锁-写锁
    void move(double deltax,double deltay){
        long stamped=s1.writeLock();
        try {
            x += deltax;
            y += deltay;
        }finally {
           s1.unlockWrite(stamped);
        }
    }

    //乐观读
    double distanceFromOrigin(){
        //尝试获取乐观读锁（1）
        long stamp=s1.tryOptimisticRead();

        // 将全部变量拷贝到方法体栈内（2）
        double currentX = x,currentY = y;

        // 检查在（1）获取到读锁票据后，锁有没被其他写线程排它性抢占（3）
        if (!s1.validate(stamp)){

            // 如果被抢占则获取一个共享读锁（悲观获取）（4）-->此时的共享读锁是互斥的，即排斥读锁以及写锁
            stamp = s1.readLock();
           try {
               // 将全部变量拷贝到方法体栈内（5）
               currentX = x;
               currentY = y;
           }finally {
               // 释放共享读锁（6）
               s1.unlockRead(stamp);
           }
        }
        return Math.sqrt(currentX*currentX + currentY*currentY);
    }

    // 使用悲观锁获取读锁，并尝试转换为写锁
    void moveIfAtOrigin(double newX,double newY){
        // 这里可以使用乐观读锁替换（1）
        long stamp= s1.readLock();
       try {
           // 如果当前点在原点则移动（2）
           while (x == 0.0 && y == 0.0){

               // 尝试将获取的读锁升级为写锁（3）
              long ws=s1.tryConvertToWriteLock(stamp);
              if (ws != 0L){
                 stamp =ws;
                 x= newX;
                 y= newY;
                 break;
              }else {
                // 读锁升级写锁失败,则释放读锁，显示获取独占写锁，然后循环重试（5）
                s1.unlockRead(stamp);
                stamp=s1.writeLock();
              }
           }
       }finally {
            // 释放锁（6）
            s1.unlock(stamp);
       }

    }

}
