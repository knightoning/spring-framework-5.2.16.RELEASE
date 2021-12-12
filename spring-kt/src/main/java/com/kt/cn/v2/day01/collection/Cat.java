package com.kt.cn.v2.day01.collection;

import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * 集合属性注入
 * @author hujie
 */
public class Cat {

	/**
	 * 注入List集合
	 */
	private List<String> listNames;

	/**
	 * 注入Set集合
	 */
	private Set<String> setNames;

	/**
	 * 注入properties
	 */
	private Properties propertiesNames;

	/**
	 * 注入Map集合
	 */
	private Map<String,String> mapNames;

	/**
	 * 注入数组
	 */
	private String[] arrayNames;

	public List<String> getListNames() {
		return listNames;
	}

	public void setListNames(List<String> listNames) {
		this.listNames = listNames;
	}

	public Set<String> getSetNames() {
		return setNames;
	}

	public void setSetNames(Set<String> setNames) {
		this.setNames = setNames;
	}

	public Properties getPropertiesNames() {
		return propertiesNames;
	}

	public void setPropertiesNames(Properties propertiesNames) {
		this.propertiesNames = propertiesNames;
	}

	public Map<String, String> getMapNames() {
		return mapNames;
	}

	public void setMapNames(Map<String, String> mapNames) {
		this.mapNames = mapNames;
	}

	public String[] getArrayNames() {
		return arrayNames;
	}

	public void setArrayNames(String[] arrayNames) {
		this.arrayNames = arrayNames;
	}

	/**
	 * 打印数组组合
	 */
	public void sayArrayNames(){
		System.out.println("注入数组------>");
		if(arrayNames != null && arrayNames.length >0){
			for (int i=0; i<arrayNames.length;i++){
				System.out.println(arrayNames[i]);
			}
		}
		System.out.println();
	}

	/**
	 * 打印Map集合
	 */
	public void sayMapNames(){
		System.out.println("注入Map集合----->");
		if(mapNames != null && mapNames.size() > 0){
			for (Map.Entry<String,String> entry : mapNames.entrySet()){
				System.out.println("key=" + entry.getKey() + " value=" + entry.getValue());
			}
		}
		System.out.println();

	}

	/**
	 * 打印Properties属性
	 */
	public void sayPropertiesNames(){
		System.out.println("注入properties------>");
		if(propertiesNames != null){
			System.out.println(propertiesNames.get("name"));
			System.out.println(propertiesNames.get("age"));
			System.out.println();
		}
	}

	/**
	 * 打印List集合
	 */
	public void sayListNames(){
		System.out.println("注入List------>");
		if(!CollectionUtils.isEmpty(listNames)){
			for(String string : listNames){
				System.out.println(string);
			}
			System.out.println();
		}
	}

	/**
	 * 打印Set集合
	 */
	public void saySetNames(){
		System.out.println("注入Set------>");
		if(!CollectionUtils.isEmpty(setNames)){
			Iterator<String> iterator = setNames.iterator();
			while (iterator.hasNext()){
				System.out.println(iterator.next());
			}
			System.out.println();
		}
	}



}
