package com.kt.cn.v2.day01.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author hujie
 *
 * 1、IoC容器启动
 * 2、实例化bean
 * 3、如果Bean实现了BeanNameAware接口，则调用setBeanName(String name)返回beanName，该方法不是设置beanName，
 *    而只是让Bean获取自己在BeanFactory配置中的名字
 * 4、如果Bean实现BeanFactoryAware接口，会回调该接口的setBeanFactory(BeanFactory beanFactory)方法，传入该Bean的BeanFactory，
 *    这样该Bean就获得了自己所在的BeanFactory
 * 5、如果Bean实现了ApplicationContextAware接口，则调用该接口的setApplicationContext(ApplicationContext applicationContext)
 *    方法，设置applicationContext
 * 6、如果有Bean实现了BeanPostProcessor接口，则调用该接口的postProcessBeforeInitialzation(Object bean，String beanName)方法，
 *    将此BeanPostProcessor应用于给定的新bean实例
 * 7、如果Bean实现了InitializingBean接口，则会回调该接口的afterPropertiesSet()方法
 * 8、如果Bean配置了init-method方法，则会执行init-method配置的方法
 * 9、如果Bean实现了BeanPostProcessor接口，则会回调该接口的postProcessAfterInitialization(Object bean，String beanName)方法
 * 10、到此为止，spring中的bean已经可以使用了，这里又涉及到了bean的作用域问题，对于singleton类型的bean，Spring会将其缓存;对于prototype
 *     类型的bean，不缓存，每次都创建新的bean的实例
 * 11、容器关，如果Bean实现了DisposableBean接口，则会回调该接口的destroy()方法销毁bean，
 * 12、如果用户配置了定destroy-method，则调用自定义方法销毁bean
 *
 */
public class LifeCycleBean implements
		                   BeanNameAware,
		                   BeanFactoryAware,
		                   ApplicationContextAware,
		                   InitializingBean,
		                   DisposableBean {

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

	@Override
	public void setBeanName(String name) {
		System.out.println("01-->BeanNameAware接口setBeanName方法被调用了,获取到的beanName:" + name);
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("02-->BeanFactoryAware接口setBeanFactory方法被调用了");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("03-->ApplicationContextAware接口setApplicationContext方法被调用了");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("05-->InitializingBean接口afterPropertiesSet方法被调用了");
	}

	public void myInit(){
		System.out.println("06-->myInit方法被调用了");
	}
	@Override
	public void destroy() throws Exception {
		System.out.println("09-->DisposableBean接口destroy方法被调用了");
	}

	public void myDestroy(){
		System.out.println("10-->自定义destroy-method方法被调用了");
	}

	@Override
	public String toString() {
		return "MyLifeCycleBean{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}
}
