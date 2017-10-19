package org.park.javadesignpattern.qday.memento.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MementoIO implements Serializable{
	
	/**
	 * ���ư��� ���� �������� Model
	 */
	
	int money;
	ArrayList fruits;
	public int getMoney() {
		return money;
	}
	public MementoIO(int money) {
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
