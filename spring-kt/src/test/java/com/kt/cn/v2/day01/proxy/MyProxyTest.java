package com.kt.cn.v2.day01.proxy;

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
}
