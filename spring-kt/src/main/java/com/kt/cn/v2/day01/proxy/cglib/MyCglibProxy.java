package com.kt.cn.v2.day01.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;


public class MyCglibProxy implements MethodInterceptor {

   private Enhancer enhancer = new Enhancer();

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        return null;
    }

    // 这里的目标类型为Object，则可以接受任意一种参数作为被代理类，实现了动态代理

}
