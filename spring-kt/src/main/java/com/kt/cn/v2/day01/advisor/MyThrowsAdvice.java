package com.kt.cn.v2.day01.advisor;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

/**
 * @author hujie
 */
public class MyThrowsAdvice implements ThrowsAdvice {

    public void afterThrowing(Method method,Object[] args,Object targe,Exception ex){
        System.out.println("==异常增强");
        System.out.println("==方法名：" + method.getName());
        if(null != args && args.length >0){
            for(int i=0; i < args.length; i++){
                System.out.println("==第" + (i + 1) + "参数" + args[i]);
            }
        }
        System.out.println("==目标类信息"+ targe.toString());
        System.out.println("==异常信息：" + ex.toString());
    }
}
