package com.kt.cn.v2.day01.parent;

/**
 * 定义子bean，注意这里SunBean和ParentBean之间无继承关系，
 * 而是通过配置文件维护父子关系
 * @author hujie
 */
public class Sun {

	/**
	 * 姓名
	 */
	private String name;

	/**
	 * 年龄
	 */
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void sayHello(){
		System.out.println("name:" + name + ", age" + age);
	}
}
