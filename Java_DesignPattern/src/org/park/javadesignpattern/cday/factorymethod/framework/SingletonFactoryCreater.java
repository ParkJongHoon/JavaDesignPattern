package org.park.javadesignpattern.cday.factorymethod.framework;

public class SingletonFactoryCreater {
	private static SingletonFactoryCreater sfc = new SingletonFactoryCreater();
	private static FactoryManager factoryManager;
	
	private SingletonFactoryCreater(){
		factoryManager = new FactoryManager();
	}
	
	public static SingletonFactoryCreater getSingletonFactoryCreater(){
		return sfc;
	}

	public static FactoryManager getFactoryManager() {
		return factoryManager;
	}
	
	

}
