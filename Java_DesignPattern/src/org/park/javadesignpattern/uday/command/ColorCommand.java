package org.park.javadesignpattern.uday.command;

import java.awt.Color;

public class ColorCommand implements Command {

	private DrawCanvas dc = null;
	private int increease = 0;
	private int remainder =0;
	private final int colorNum = 5;

	public ColorCommand(DrawCanvas dc) {
		this.dc = dc;
	}
	
	@Override
	public void execute() {
		remainder=increease%colorNum;
		
		if(remainder == 1){
			dc.setColor(Color.red);
		}else if(remainder == 2){
			dc.setColor(Color.blue);
		}else if(remainder == 3){
			dc.setColor(Color.yellow);
		}else if(remainder == 4){
			dc.setColor(Color.green);
		}else{
			dc.setColor(Color.black);
		}
		increease++;
	}

}
