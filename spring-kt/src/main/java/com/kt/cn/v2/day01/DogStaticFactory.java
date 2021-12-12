package com.kt.cn.v2.day01;

/**
 * 静态工厂实例化
 * @author hujie
 */
public class DogStaticFactory {

	/**
	 * 静态工厂方法
	 * @param name
	 * @param age
	 * @return
	 */
	public static Dog newInstance(String name,int age){
		//返回需要的Bean实例
		return new Dog(name,age);
	}
}
