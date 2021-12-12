package com.kt.cn.v2.day01.method.lookupMethod;

/**
 * 未使用lookup-method注入时，通过Car的实例获取的Taxi实例是被缓存的（配置文件中Taxi的scope="prototype"）；
 * 而使用了lookup-method注入时，通过Car的实例获取的Taxi实例则是每次都是新建的，不是被缓存的，这也就达到了我们的目的
 * @author hujie
 */
public abstract class Car {

	//用于lookup-method注入
	public abstract Taxi createTaxi();

	private Taxi taxi;

	public Taxi getTaxi(){
		return taxi;
	}

	//Setter 注入
	public void setTaxi(Taxi taxi){
		this.taxi = taxi;
	}
}
