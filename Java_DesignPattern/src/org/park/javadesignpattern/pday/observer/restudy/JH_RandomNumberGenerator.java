package org.park.javadesignpattern.pday.observer.restudy;

import java.util.List;
import java.util.Random;

public class JH_RandomNumberGenerator {
	private Random random = null;
	private int loopNumber = 0;
	private int number = 0;
	
	public JH_RandomNumberGenerator(int loopNumber) {
		this.loopNumber = loopNumber;
		random = new Random();
		
	}

	public int getNumber() {
		return number;
	}
	
	public List<Integer> execute(List<Integer> list){
		for(int i=0; i<loopNumber; i++){
			number = random.nextInt(50);
			list.add(number);
		}
		return list;
	}
	
	
}
