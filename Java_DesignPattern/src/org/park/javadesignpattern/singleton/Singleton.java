package org.park.javadesignpattern.singleton;

public class Singleton {
	private static Singleton singleton = new Singleton();
	private Singleton(){
		System.out.println("�ν��Ͻ��� �����߽��ϴ�.");
	}
	public static Singleton getSingleton(){
		return singleton;
	}
}
