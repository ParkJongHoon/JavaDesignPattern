package org.park.javadesignpattern.builder.main;



import org.park.javadesignpattern.builder.example.ExecutePlan;
import org.park.javadesignpattern.builder.example.InstanceManager;

public class BuilderMain2 {
	/**
	 * 작성일: 2017-05-17
	 * 작성자: 박종훈
	 * 작성내용: Builder pattern
	 * 1) Builder 클래스에 행동패턴에 대한 추상메소드로 정의한다.
	 * 2) Builder 클래스의 추상메소드를 구현할 내용을 Builder클래스를 상속받은 후 구현한다.
	 * -> HTMLBuilder, TextBuilder 클래스이며 ConcreteBuilder역할을 담당한다.
	 * 3) Director 클래스에서 생성자부분에 Builder클래스 객체를 주입하는 부분을 생성하고
	 * 주입받은 객체에 대한 실행계획을 가진을 실행메소드를 만든다.(construct()) 
	 * @param args
	 */
	
	public static void main(String[] args) {	 
		InstanceManager instanceManager = new InstanceManager();
		ExecutePlan executePlan = new ExecutePlan(instanceManager);
		executePlan.execute(args);
	}

}
