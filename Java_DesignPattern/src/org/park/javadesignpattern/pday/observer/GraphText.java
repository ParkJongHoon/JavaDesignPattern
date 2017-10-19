package org.park.javadesignpattern.pday.observer;

import java.awt.TextField;

public class GraphText extends TextField implements Observer {
	public GraphText(int columns) {
		super(columns);
	}

	@Override
	public void update(NumberGenerator generator) {
		int number = generator.getNumber();
		String text = number + ":";
		for(int i =0; i < number; i++){
			text += '*';
		}
		setText(text);
	}

}
