package com.kt.cn.v2.day01.advice;

import com.kt.cn.v2.day01.advisor.*;
import org.junit.Test;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

public class MyAdivceTest {

    @Test
    public void test1(){

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

    @Test
    public void test2(){
        //后置增强
        //1、实例化bean和增强
        Animal dog =  new Dog();
        MyAfterReturningAdvce advce = new MyAfterReturningAdvce();

        //2、创建ProxyFactory并设置代理目标和增强
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(dog);
        proxyFactory.addAdvice(advce);

        //3、生成代理
        Animal proxyDog = (Animal) proxyFactory.getProxy();
        proxyDog.sayHello("二哈",3);
    }

    @Test
    public void test3(){

        //环绕增强
        // 1、实例化bean和增强
        Animal dog = new Dog();
        MyMethodInterceptor advice = new MyMethodInterceptor();

        //2、创建ProxyFactoy并设置代理目标和增强
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(dog);
        proxyFactory.addAdvice(advice);

        //3、生成代理实例
        Animal proxyDog = (Animal) proxyFactory.getProxy();
        proxyDog.sayHello("二哈",3);
    }

    @Test
    public void test4(){

        //1、创建目标类、增强、切入点
        Animal animal = new Dog();
        MyMethodBeforeAdvice advice = new MyMethodBeforeAdvice();
        MyStaticPointcutAdvisor advisor = new MyStaticPointcutAdvisor();

        //2、创建ProxyFactory并设置目标类、增强、切面
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(animal);
        // 为切面提供增强
        advisor.setAdvice(advice);
        proxyFactory.addAdvisor(advisor);

        //3、生成代理实例
        Dog proxyDog =(Dog) proxyFactory.getProxy();
        proxyDog.sayHelloDog();
        System.out.println("\n\n");
        proxyDog.sayHello("dog",13);
    }
}
