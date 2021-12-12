package com.kt.cn.v2.day01.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author hujie
 */
public class LifeCycleBeanPostProcessor implements BeanPostProcessor {


	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

		if(bean instanceof LifeCycleBean){
			System.out.println("04-->调用BeanPostProcessor的postProcessBeforeInitialization方法，获取到的beanName:" + beanName);
			((LifeCycleBean) bean).setName("李四");
		}

		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

		if(bean instanceof LifeCycleBean){
			System.out.println("07-->调用BeanPostProcessor的postProcessAfterInitialization,获取到的beanName:" + beanName);
			((LifeCycleBean) bean).setAge(30);
		}

		return bean;
	}
}
