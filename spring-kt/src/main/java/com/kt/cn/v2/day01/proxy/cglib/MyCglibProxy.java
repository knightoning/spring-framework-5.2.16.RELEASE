package com.kt.cn.v2.day01.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import java.lang.reflect.Method;


public class MyCglibProxy implements MethodInterceptor {

   private Enhancer enhancer = new Enhancer();

//
//    public Object getInstance(Class clazz){
//        enhancer.setSuperclass(clazz);
//        enhancer.setCallback(this);
//
//        return enhancer.create();
//    }
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

//        System.out.println("==代理方法开始执行");
//        Object result = methodProxy.invokeSuper(o,objects);
//        System.out.println("==代理方法开始结束");
//        return result;
        return null;
    }
}
