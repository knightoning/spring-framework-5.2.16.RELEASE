package com.kt.cn.v2.day01.advice;

import com.kt.cn.v2.day01.advisor.Animal;
import com.kt.cn.v2.day01.advisor.Dog;
import com.kt.cn.v2.day01.advisor.MyMethodBeforeAdvice;
import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;

public class MyAdivceTest {

    @Test
    public void test(){

        //前置增强
        //1、实例化bean和增强
        Animal dog = new Dog();
        MyMethodBeforeAdvice advice =  new MyMethodBeforeAdvice();

        //2、创建ProxyFactory并设置代理目标和增强
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(dog);
        proxyFactory.addAdvice(advice);

        //3、生成代理实例
        Animal proxyDog = (Animal) proxyFactory.getProxy();
        proxyDog.sayHello("二哈",3);
    }
}
