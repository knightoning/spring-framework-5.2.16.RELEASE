package com.kt.cn.v2.day01.processor.bean;

import com.kt.cn.v2.day01.Dog;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

/**
 * 继承BeanPostProcessor接口并重写其方法
 * @author hujie
 */
public class MyBeanPostProcessorOne implements BeanPostProcessor, Ordered {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("BeanPostProcessor第" + getOrder()+"次被调用\n");
		if(bean instanceof Dog){
			((Dog) bean).setName("强强");
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if(bean instanceof Dog){
			((Dog) bean).setAge(5);
		}
		return bean;
	}

	@Override
	public int getOrder() {
		return 1;
	}
}
