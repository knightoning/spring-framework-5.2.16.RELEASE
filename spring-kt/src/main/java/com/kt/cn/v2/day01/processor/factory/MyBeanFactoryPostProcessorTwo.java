package com.kt.cn.v2.day01.processor.factory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.Ordered;

/**
 * 修改dog的name属性
 * 修改dog的作用域
 */
public class MyBeanFactoryPostProcessorTwo implements BeanFactoryPostProcessor, Ordered {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("BeanFactoryPostProcessor第"+getOrder()+"次被调动");
	}

	@Override
	public int getOrder() {
		return 1;
	}
}
