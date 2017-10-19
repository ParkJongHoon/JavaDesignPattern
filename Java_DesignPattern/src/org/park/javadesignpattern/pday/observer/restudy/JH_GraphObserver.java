package org.park.javadesignpattern.pday.observer.restudy;

public class JH_GraphObserver implements JH_Observer {

	@Override
	public void update(int number) {
		System.out.print("GraphObserver:");
		for(int i =0; i < number; i++){
			System.out.print("*");
		}
		System.out.println();
		try{
			Thread.sleep(100);
		}catch(InterruptedException e){
			e.printStackTrace();
		}

	}

}
