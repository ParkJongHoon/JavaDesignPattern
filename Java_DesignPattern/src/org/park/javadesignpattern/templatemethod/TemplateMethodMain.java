package org.park.javadesignpattern.templatemethod;

public class TemplateMethodMain {
	
	/**
	 * 설명: 실행계획은 최상위의 추상클래스에서 
	 * 실행계획을 가진 메소드를 final로 구현함(하위클래스에서 접근 못하도록)
	 * 수행될 각각의 메소드를 상위 추상클래스에서 추상메소드로 정의만하고
	 * 그 추상메소드에 대한 구현은 하위클래스 구현한다.
	 * 실행계획은 고정이고, 구현되는 내용은 구현하는 하위클래스에 따라서
	 * 달라질 수 있다.
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		AbstractDisplay d1 = new CharDisplay('H');
		AbstractDisplay d2 = new StringDisplay("Hello, world.");
		AbstractDisplay d3 = new StringDisplay("안녕하세요");
		d1.display();
		d2.display();
		d3.display();
	}

}
