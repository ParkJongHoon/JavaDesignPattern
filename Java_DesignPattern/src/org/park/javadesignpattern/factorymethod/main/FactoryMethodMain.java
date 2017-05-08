package org.park.javadesignpattern.factorymethod.main;

import org.park.javadesignpattern.factorymethod.framework.Factory;
import org.park.javadesignpattern.factorymethod.framework.Product;
import org.park.javadesignpattern.factorymethod.idcard.IDCard;
import org.park.javadesignpattern.factorymethod.idcard.IDCardFactory;


/**
 * 작성자 박종훈
 * 작성날짜 2017-05-08
 * 작성내용:
 * 
 * 알게된 점 1) 추상 메소드로 정의한 것은 메인클래스에서 가져올 수 없다.
 * -> 오직 추상메소드에서 선언한 클래스에서 특정 메소드에서 선언하는 방식으로
 * 사용된다.
 *           2) Factory 추상클래스를 구현한 클래스는 자료구조를 관리 및
 *              앱 전체를 실행하는 계획을 가지고 있는 프레임워크 이다.
 *                  
 *           3) Product 추상클래스를 구현한 클래스는 각 객체가 실행될 때
 *           동작하는 행위들을 구현한다.
 *            
 * 
 *
 */
public class FactoryMethodMain {

	public static void main(String[] args) {
		Factory factory = new IDCardFactory();
		Product card1 = factory.create("홍길동");
		Product cart2 = factory.create("이순실");
		Product cart3 = factory.create("강감찬");
		
		card1.use();
		cart2.use();
		cart3.use();
		
	}

}
