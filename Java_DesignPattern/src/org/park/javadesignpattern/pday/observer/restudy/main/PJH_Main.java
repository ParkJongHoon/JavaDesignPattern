package org.park.javadesignpattern.pday.observer.restudy.main;

import org.park.javadesignpattern.pday.observer.NumberGenerator;
import org.park.javadesignpattern.pday.observer.Observer;
import org.park.javadesignpattern.pday.observer.restudy.JH_Observer;
import org.park.javadesignpattern.pday.observer.restudy.JH_RandomNumberGenerator;
import org.park.javadesignpattern.pday.observer.restudy.ObserverManager;

import tools.dynamiccreate.DynamicObjectCreater;

public class PJH_Main {

	

	public static void main(String[] args) {
	/*
	NumberGenerator generator = (NumberGenerator)DynamicObjectCreater.newInstanceObject("RandomNumberGenerator");
	Observer observer1 = (Observer)DynamicObjectCreater.newInstanceObject("DigitObserver");
	Observer observer2 = (Observer)DynamicObjectCreater.newInstanceObject("GraphObserver");
	generator.addObserver(observer1);
	generator.addObserver(observer2);
	generator.execute();
	*/
	JH_RandomNumberGenerator rg = (JH_RandomNumberGenerator)DynamicObjectCreater.newInstanceObject
				("JH_RandomNumberGenerator", 50);
	ObserverManager observerManager = (ObserverManager)DynamicObjectCreater.newInstanceObject("ObserverManager", rg);
	JH_Observer observer1 = (JH_Observer)DynamicObjectCreater.newInstanceObject("JH_DigitObserver");
	JH_Observer observer2 = (JH_Observer)DynamicObjectCreater.newInstanceObject("JH_GraphObserver");
	observerManager.addObserver(observer1);
	observerManager.addObserver(observer2);
	observerManager.execute();
	}
	

}
