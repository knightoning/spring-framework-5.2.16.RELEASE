package com.kt.cn.v2.day01.advisor;

/**
 * @author hujie
 */
public class Dog implements Animal{

    @Override
    public void sayHello(String name, int age) {
        System.out.println("==名字：" + name + " 年龄：" +age);
    }

    public void sayHelloDog(){
        System.out.println("我是一只狗...");
    }
}
