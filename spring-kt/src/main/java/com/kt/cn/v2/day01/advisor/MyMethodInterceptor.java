package com.kt.cn.v2.day01.advisor;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyMethodInterceptor implements MethodInterceptor {


    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("==环绕增强开始");
        System.out.println("==方法名：" + invocation.getMethod().getName());

        Object[] args =  invocation.getArguments();
        if(null != args && args.length > 0){
            for (int i=0; i < args.length; i++){
                System.out.println("==第" + (i + 1) + "参数：" + args[i] );
            }
        }

        Object proceed =  invocation.proceed();
        System.out.println("==环绕增强结束");

        return proceed;
    }
}
