package com.kt.cn.v2.day01.proxy;

import com.kt.cn.v2.day01.proxy.cglib.CglibCat;
import com.kt.cn.v2.day01.proxy.cglib.MyCglibProxy;
import com.kt.cn.v2.day01.proxy.jdk.JDKAnimal;
import com.kt.cn.v2.day01.proxy.jdk.JDKDog;
import com.kt.cn.v2.day01.proxy.jdk.MyInvocationHandler;
import com.kt.cn.v2.day01.proxy.statc.CountImpl;
import com.kt.cn.v2.day01.proxy.statc.CountProxy;
import org.junit.Test;

public class MyProxyTest {

    @Test
    public void test1(){

        //静态代理
        CountImpl countImpl = new CountImpl();
        CountProxy countProxy = new CountProxy(countImpl);
        countProxy.updateCount();
        System.out.println("\n**********\n");
        countProxy.queryCount();

    }

    @Test
    public void test2(){

        //JDK动态代理
        MyInvocationHandler handler = new MyInvocationHandler(new JDKDog());
        JDKAnimal proxy = (JDKAnimal) handler.getProxy();
        proxy.sayHello();
    }

    @Test
    public void test4(){
        //CGLIB动态代理
       // CglibCat cat = (CglibCat) new MyCglibProxy().getInstance(CglibCat.class);
       // cat.sayHello();
    }
}
