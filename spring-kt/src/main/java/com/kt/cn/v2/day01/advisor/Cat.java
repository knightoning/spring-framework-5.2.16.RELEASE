package com.kt.cn.v2.day01.advisor;

/**
 * @author hujie
 */
public class Cat implements Animal{

    @Override
    public void sayHello(String name, int age) {
        System.out.println("我是Cat类的sayHello方法...");
    }

    public void sayHelloCa(){
        System.out.println("我是一只喵...");
    }
}
