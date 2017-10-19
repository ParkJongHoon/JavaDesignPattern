package org.park.javadesignpattern.pday.observer.restudy;

public class JH_DigitObserver implements JH_Observer {

	@Override
	public void update(int number) {
		System.out.println("DigitObserver: " + number);
		try{
			Thread.sleep(100);
		}catch(InterruptedException e){}
	}

}
