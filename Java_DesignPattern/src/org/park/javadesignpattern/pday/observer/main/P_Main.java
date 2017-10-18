package org.park.javadesignpattern.pday.observer.main;

import org.park.javadesignpattern.pday.observer.NumberGenerator;
import org.park.javadesignpattern.pday.observer.Observer;

import tools.dynamiccreate.DynamicObjectCreater;

public class P_Main {

	public static void main(String[] args) {
	NumberGenerator generator = (NumberGenerator)DynamicObjectCreater.newInstanceObject("RandomNumberGenerator");
	Observer observer1 = (Observer)DynamicObjectCreater.newInstanceObject("DigitObserver");
	Observer observer2 = (Observer)DynamicObjectCreater.newInstanceObject("GraphObserver");
	generator.addObserver(observer1);
	generator.addObserver(observer2);
	generator.execute();
	}

}
