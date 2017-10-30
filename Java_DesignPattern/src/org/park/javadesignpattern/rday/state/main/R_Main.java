package org.park.javadesignpattern.rday.state.main;

import org.park.javadesignpattern.rday.state.SafeFrame;

public class R_Main {
	public static void main(String[] args) {
		SafeFrame frame = new SafeFrame("State Sample");
		while(true){
			for(int hour = 0; hour < 24; hour ++){
				frame.setClock(hour);	// �ð�����
				try{
					Thread.sleep(1000);
				}catch(InterruptedException e){					
				}
			}
		}
	}
}
