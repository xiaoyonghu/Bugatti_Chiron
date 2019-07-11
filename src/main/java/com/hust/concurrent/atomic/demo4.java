package com.hust.concurrent.atomic;

import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * @author Created by Divo
 * @date 2019/7/1
 * 原子地更新属性
 */
public class demo4 {
    public static void main(String[] args) {


        AtomicLongFieldUpdater<Student> atomicLongFieldUpdater = AtomicLongFieldUpdater.newUpdater(Student.class,"id");
        Student student = new Student(1L, "Divo");

        //跟新非包装型
        atomicLongFieldUpdater.compareAndSet(student,1L,100L);//直接看源代码
        System.out.println("id = "+student.getId());

        //跟新包装型
        AtomicReferenceFieldUpdater<Student, String> atomicReferenceFieldUpdater = AtomicReferenceFieldUpdater.newUpdater(Student.class,String.class,"name");
        atomicReferenceFieldUpdater.compareAndSet(student,"Divo","Adolf Hitler");

        System.out.println("name = "+student.getName());

    }
}
class Student{
   // 字段必须是volatile类型的，在线程之间共享变量时保证立即可见
     volatile long id;//非包装型
    volatile String name;  //包装型

    public Student(long id, String name) {
        this.id = id;
        this.name = name;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}