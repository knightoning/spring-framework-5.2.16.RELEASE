package com.kt.cn.v2.day01.factoryBean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author hujie
 */
public class FurnitureFactoryBean implements FactoryBean<Furniture> {

	private String furniture;

	public void setFurniture(String furniture) {
		this.furniture = furniture;
	}

	@Override
	public Furniture getObject() throws Exception {

		if(furniture == null){
			throw new IllegalArgumentException("'furniture' is required");
		}

		if("chair".equals(furniture)){
			return new Chair();
		}
		if("desk".equals(furniture)){
			return new Desk();
		}
		throw new IllegalArgumentException("'furniture' type error");
	}

	@Override
	public Class<?> getObjectType() {

		if(furniture == null){
			throw new IllegalArgumentException("'furniture' is required");
		}

		if("chair".equals(furniture)){
			return Chair.class;
		}

		if("desk".equals(furniture)){
			return Desk.class;
		}

		throw new IllegalArgumentException("'furniture' type error");
	}

	@Override
	public boolean isSingleton() {
		return true;
	}
}
