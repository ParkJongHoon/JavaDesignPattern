package org.park.javadesignpattern.pday.observer.restudy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ObserverManager {
	private ArrayList<JH_Observer> observers = new ArrayList<JH_Observer>();		// Observer를 저장
	private JH_RandomNumberGenerator rg = null;
	
	public ObserverManager(JH_RandomNumberGenerator rg) {
		this.rg = rg;
	}
	public void addObserver(JH_Observer observer){			// Observer를 추가
		observers.add(observer);
	}
	
	public void deleteObserver(JH_Observer observer){
		observers.remove(observer);
	}
	
	public void execute(){
		List<Integer> list = rg.execute(new ArrayList<Integer>());
		Iterator<Integer> it = list.iterator();
		int number = 0;
		while(it.hasNext()){
			number = it.next().intValue();
			Iterator<JH_Observer> it2 = observers.iterator();
			while(it2.hasNext()){
				JH_Observer o = (JH_Observer)it2.next();
					o.update(number);
			}
		}	
	}
}
