package org.park.javadesignpattern.qday.memento;

import java.util.ArrayList;
import java.util.List;

public class Memento {
	
	/**
	 * 돌아가고 싶은 상태저장 Model
	 */
	
	int money;
	ArrayList fruits;
	public int getMoney() {
		return money;
	}
	public Memento(int money) {
		this.money = money;
		this.fruits = new ArrayList();
	}
	void addFruit(String fruit){
		fruits.add(fruit);
	}
	List getFruits(){
		return (List)fruits.clone();
	}
	
}
