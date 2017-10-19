package org.park.javadesignpattern.pday.observer;

public class IncrementalNumberGenerator extends NumberGenerator {
	private int startNum;
	private	int endNum;
	private int incresingNum;
	private int number;
	
	public IncrementalNumberGenerator(int startNum, int endNum, int incresingNum) {
		this.startNum = startNum;
		this.endNum = endNum;
		this.incresingNum = incresingNum;
	}

	@Override
	public int getNumber() {
		return number;
	}

	@Override
	public void execute() {
		int transationNum = 0;
		transationNum = startNum;
		for(; transationNum< this.endNum; transationNum =transationNum+this.incresingNum){
			this.number = transationNum;
			notifyObservers();
		}

	}

}
