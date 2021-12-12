package com.kt.cn.v2.day01;

/**
 * 工厂方法实例化
 * @author hujie
 */
public class DogFactory {

	public Dog newInstance(String name, int age){
		return new Dog(name,age);
	}

}
