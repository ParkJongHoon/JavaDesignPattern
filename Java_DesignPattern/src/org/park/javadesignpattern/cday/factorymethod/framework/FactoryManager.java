package org.park.javadesignpattern.cday.factorymethod.framework;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 
 * 작성자 박종훈
 * 작성일 2017-08-24
 * 작성내용: Factory pattern 관리기능(검색, 저장)
 * private Map<String, Product> product <- Product Domain 저장
 * private List<String> productKey <- product Map의 키 관리
 * private Map<String , String> productKeyManager <- productKey List 관리	
 */

public class FactoryManager {
	private static final String dynamicObjctPackagePath = "org.park.javadesignpattern.factorymethod.domain";
	private Factory factory;
	private Map<String, Product> product;
	private List<String> productKey;
	private Map<String , String> productKeyManager;
	
	public FactoryManager() {
		product = new HashMap<String, Product>();
		productKey = new ArrayList<String>();
		productKeyManager = new HashMap<String, String>();
	}
	
	public FactoryManager(String factoryName) {
		this.factory = dynamicObjectCreate(factoryName);
		product = new HashMap<String, Product>();
		productKey = new ArrayList<String>();
		productKeyManager = new HashMap<String, String>();
	}
	
	public void createProduct(String owner){
		productKeyManager.put(owner, String.valueOf(productKey.size()));
		product.put(owner,factory.create(owner));
		productKey.add(owner);
	}
	
	public void removeProduct(String owner){
		productKey.remove(getNumber(owner));
		product.remove(owner);
		productKeyManager.remove(owner);
	}
	
	public int getNumber(String owner){
		return Integer.parseInt(productKeyManager.get(owner));
	}
	
	public void use(String owner){
		product.get(owner).use();
	}
	
	public void betchProcess(){
		System.out.println();
		Iterator<String> iterator = productKey.iterator();
		while(iterator.hasNext()){
			product.get(iterator.next()).use();
			
		}
	}

	public void setFactory(Factory factory) {
		this.factory = factory;
	}
	
	public void setFactory(String factoryName) {
		this.factory = dynamicObjectCreate(factoryName);
	}
	
	public Factory dynamicObjectCreate(String factoryName){
		
		Factory factory = null;
		try {
			Class classtype = Class.forName(dynamicObjctPackagePath+ "."+factoryName);
			Constructor construct = classtype.getConstructor();
			factory = (Factory)construct.newInstance();
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return factory;
	} 
	
	

}
