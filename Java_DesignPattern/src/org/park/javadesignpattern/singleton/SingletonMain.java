package org.park.javadesignpattern.singleton;

public class SingletonMain {
	
	/**
	 * 작성자: 박종훈
	 * 작성일: 2017-05-08
	 * 작성내용: Singleton Pattern
	 * 아래 내용을 이용하여  하나의 객체만 생성하고
	 * private static Singleton singleton = new Singleton();
	 * getSingleton()을 이용하여 생성된 객체를 전달한다.
	 * 
	 * 메인 클래스에서는 해당 객체로 접근자체가 안됨(private 설정)
	 * 
	 */

	public static void main(String[] args) {
		System.out.println("Start. ");
		Singleton obj1 = Singleton.getSingleton();
		Singleton obj2 = Singleton.getSingleton();
		if(obj1 == obj2){
			System.out.println("obj1과 obj2는 같은 인스턴스입니다.");
		}else{
			System.out.println("obj1과 obj2는 다른 인스턴스입니다.");
		}
		System.out.println("End. ");
	}

}
