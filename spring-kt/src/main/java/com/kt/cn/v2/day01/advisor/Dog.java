package com.kt.cn.v2.day01.advisor;

/**
 * @author hujie
 */
public class Dog implements Animal{

    @Override
    public void sayHello(String name, int age) {
        System.out.println("==名字：" + name + " 年龄：" +age);
    }

    @Override
    public void sayException(String name, int age) {
        System.out.println("==名字：" + name + " 年龄：" +age);
       // System.out.println("==抛出异常：" + 1 / 0);
    }
}
