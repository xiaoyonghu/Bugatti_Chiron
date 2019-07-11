package com.hust.concurrent.atomic;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Created by Divo
 * @date 2019/7/1
 * 原子更新引用
 * AtomicReference 的使用用例
 */
public class demo5 {
    public static void main(String[] args) {
        //内心感觉真是TMD麻烦
        AtomicReference<Student> atomicReference = new AtomicReference<>();
        Student student = new Student(1L, "xiaosangsang");
        Student student1 = new Student(1L, "haiminghe");
        atomicReference.set(student);
        atomicReference.compareAndSet(student, student1);
        Student student2 = atomicReference.get();
        System.out.println(student2.getName());
    }
}

class Employee {
    private long id;
    private String name;

    public Employee(long id, String name) {
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