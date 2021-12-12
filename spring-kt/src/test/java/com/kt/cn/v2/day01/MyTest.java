package com.kt.cn.v2.day01;

import com.kt.cn.v2.day01.collection.Cat;
import com.kt.cn.v2.day01.factoryBean.Furniture;
import com.kt.cn.v2.day01.inner.Outer;
import com.kt.cn.v2.day01.lifecycle.LifeCycleBean;
import com.kt.cn.v2.day01.method.lookupMethod.Car;
import com.kt.cn.v2.day01.method.lookupMethod.Taxi;
import com.kt.cn.v2.day01.method.replaceMethod.OriginalDog;
import com.kt.cn.v2.day01.parent.Sun;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * @author hujie
 */
public class MyTest {

	private XmlBeanFactory xmlBeanFactory;

	@Before
	public void initXmlBeanFactory() {
		System.setProperty("spring.profiles.active", "dev");
		System.out.println("\n=================测试方法开始=================\n");
		xmlBeanFactory = new XmlBeanFactory(new ClassPathResource("v2/day01.xml"));
	}

	@After
	public void after(){
		System.out.println("\n==================测试方法结束=================\n");
	}

	@Test
	public void test1(){
		//默认构造器
		System.out.println("默认构造器");
		Dog dog1 = xmlBeanFactory.getBean("dog1",Dog.class);
		dog1.setName("dog1");
		dog1.setAge(50);
		dog1.sayHello();
	}

	@Test
	public void test2(){
		//有参构造器
		System.out.println("有参构造器");
		Dog dog2 = xmlBeanFactory.getBean("dog2",Dog.class);
		dog2.sayHello();
	}

	@Test
	public void test3(){
		//静态工厂
		System.out.println("静态工厂");
		Dog dog3 = xmlBeanFactory.getBean("dog3",Dog.class);
		dog3.sayHello();
	}

	@Test
	public void test4(){
		//实例工厂
		System.out.println("实例工厂");
		Dog dog4 = xmlBeanFactory.getBean("dog4",Dog.class);
		dog4.sayHello();
	}

	@Test
	public void test5(){
		System.out.println("内部类");
		Outer outer= xmlBeanFactory.getBean("outer",Outer.class);
		outer.sayHello();
 	}

 	@Test
	public void test6(){
		Sun sun = xmlBeanFactory.getBean("sun",Sun.class);
		sun.sayHello();
	}

	@Test
	public void test7(){
		//注入集合属性
		Cat cat = xmlBeanFactory.getBean("cat",Cat.class);
		cat.sayArrayNames();
		cat.sayListNames();
		cat.sayMapNames();
		cat.sayPropertiesNames();
		cat.saySetNames();
	}

	@Test
	public void test8(){
		//测试lookup-method注入
		Car car1 = xmlBeanFactory.getBean("car",Car.class);
		Car car2 = xmlBeanFactory.getBean("car",Car.class);
		System.out.println("Car:singleton,所以animal1 = animal2 应该为"+(car1 == car1));

		Taxi taxi1 = car1.getTaxi();
		Taxi taxi2 = car2.getTaxi();
		System.out.println("Taxi:prototye,Car:singleton,未使用lookup-method注入所以taxi1 == taxi2 应该为"+(taxi1 == taxi2));

		//这里通过createDog()方法获取
		Taxi taxi3 = car1.createTaxi();
		Taxi taxi4 = car2.createTaxi();
		System.out.println("Taxi:prototype,Car:singleton,使用了lookup-method注入所以taxi3 == taxi4 应该为" +(taxi3 == taxi4));


	}

	@Test
	public void test9(){
		OriginalDog originalDog = xmlBeanFactory.getBean("originalDogReplaceMethod",OriginalDog.class);
		originalDog.sayHello("输出结果已经被替换...");
	}

	@Test
	public void test10(){
		System.out.println(xmlBeanFactory.getBean("student"));
		System.out.println(xmlBeanFactory.getBean("&student"));

	}

	@Test
	public void test11(){
		//FactoryBean简单工厂测试
		Furniture furniture = xmlBeanFactory.getBean("furniture",Furniture.class);
		furniture.sayHello();
	}

	@Test
	public void test12(){
		//生命周期测试
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("v2/day01.xml");
		LifeCycleBean myLifeCycleBean = applicationContext.getBean("myLifeCycleBean",LifeCycleBean.class);
		System.out.println("08-->bean可以被使用了，beanInfo:" + myLifeCycleBean.toString());
		((ClassPathXmlApplicationContext)applicationContext).destroy();
	}

	@Test
	public void test13(){
		//测试BeanPostProcessor，注释掉day02.xml中 id="myBeanFactoryPostProcessorOne" 和id="myBeanFactoryPostProcessorTwo"
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("v2/day02.xml");
		Dog dog = applicationContext.getBean("dog",Dog.class);
		dog.sayHello();
	}

	@Test
	public void test14(){
		//测试BeanFactoryPostProcessor,注释掉day02.xml中id="myBeanPostProcessorOne" 和id="myBeanPostProcessorTwo"
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("v2/day02.xml");
		Dog dog = applicationContext.getBean("dog",Dog.class);
		dog.sayHello();
	}
}
