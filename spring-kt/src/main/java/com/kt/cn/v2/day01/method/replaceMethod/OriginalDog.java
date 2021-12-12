package com.kt.cn.v2.day01.method.replaceMethod;

/**
 * OriginalDog类的sayHello方法输出的是Hello,I am a black dog, my name is xxx，
 * 但是通过replace-method注入，成功的将其替换成reimplement方法。
 *
 * @author hujie
 */
public class OriginalDog {

	public void sayHello(){
		System.out.println("Hello,I am a black dog...");
	}

	public void sayHello(String name){
		System.out.println("Hello,I am a black dog,my name is"+name);
	}
}
