package com.kt.cn.v2.day01.processor.factory;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.Ordered;

/**
 * 修改dog的name属性
 * 修改dog的作用域
 */
public class MyBeanFactoryPostProcessorOne implements BeanFactoryPostProcessor, Ordered {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

		System.out.println("BeanFactoryPostProcessor第"+getOrder()+"次被调动");
		BeanDefinition beanDefinition = beanFactory.getBeanDefinition("dog");
		if(beanDefinition != null){
			System.out.println("dog属性值：" + beanDefinition.getPropertyValues().toString());
			MutablePropertyValues propertyValues = beanDefinition.getPropertyValues();
			if (propertyValues.contains("name")){
				System.out.println("修改dog的name属性值为强强");
				propertyValues.addPropertyValue("name","强强");
			}
			System.out.println("修改dog的作用域为prototype\n");
			beanDefinition.setScope(BeanDefinition.SCOPE_PROTOTYPE);
		}
	}

	@Override
	public int getOrder() {
		return 0;
	}
}
