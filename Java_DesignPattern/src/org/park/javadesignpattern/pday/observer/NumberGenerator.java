package org.park.javadesignpattern.pday.observer;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class NumberGenerator {
	private ArrayList<Observer> observers = new ArrayList<Observer>();		// Observer를 저장
	public void addObserver(Observer observer){			// Observer를 추가
		observers.add(observer);
	}
	
	public void deleteObserver(Observer observer){
		observers.remove(observer);
	}
	
	public void notifyObservers(){
		Iterator<Observer> it = observers.iterator();
		while(it.hasNext()){
			Observer o = (Observer)it.next();
			o.update(this);
		}
	}
	public abstract int getNumber();
	public abstract void execute();
}
