package org.park.javadesignpattern.pday.observer;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class GraphCanvas extends Canvas implements Observer {
	private int number;

	@Override
	public void update(NumberGenerator generator) {
		number = generator.getNumber();
		repaint();
	}
	
	@Override
	public void paint(Graphics g) {
		int width = getWidth();
		int heignt = getHeight();
		g.setColor(Color.white);
		g.fillArc(0, 0, width, heignt, 0, 360);
		g.setColor(Color.red);
		g.fillArc(0, 0, width, heignt, 90, -number*360/50);
	}

}
