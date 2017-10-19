package org.park.javadesignpattern.pday.observer.main;

import org.park.javadesignpattern.pday.observer.NumberGenerator;
import org.park.javadesignpattern.pday.observer.Observer;

import tools.dynamiccreate.DynamicObjectCreater;

public class P_Main3 {
	/**
	 * Observer 패턴은?
	 * 상태 변화에 따른 처리기술을 표현함
	 * 1) Observer를 관리 할 클래스: NumberGenerator
	 * 2) 숫자생성기: RandomNumberGenator
	 * 3) 상태 표시 할 클래스: Observer (상속)--> GraphObserver, DigitObserver
	 * @param args
	 */
	

	public static void main(String[] args) {
	NumberGenerator generator = (NumberGenerator)DynamicObjectCreater.newInstanceObject("RandomNumberGenerator");
	Observer observer1 = (Observer)DynamicObjectCreater.newInstanceObject("DigitObserver");
	Observer observer2 = (Observer)DynamicObjectCreater.newInstanceObject("GraphObserver");
	Observer observer3 = (Observer)DynamicObjectCreater.newInstanceObject("FrameObserver");
	generator.addObserver(observer1);
	generator.addObserver(observer2);
	generator.addObserver(observer3);
	generator.execute();
	}

}
