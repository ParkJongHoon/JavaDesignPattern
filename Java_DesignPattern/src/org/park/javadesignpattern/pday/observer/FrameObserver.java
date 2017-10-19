package org.park.javadesignpattern.pday.observer;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameObserver extends Frame implements Observer, ActionListener {
	private GraphText textGraph = new GraphText(60);
	private GraphCanvas canvasGraph = new GraphCanvas();
	private Button buttonClose = new Button("Close");
	
	public FrameObserver() {
		super("FrameObserver");
		setLayout(new BorderLayout());
		setBackground(Color.lightGray);
		textGraph.setEditable(false);
		canvasGraph.setSize(500, 500);
		add(textGraph, BorderLayout.NORTH);
		add(canvasGraph, BorderLayout.CENTER);
		add(buttonClose, BorderLayout.SOUTH);
		buttonClose.addActionListener(this);
		pack();
		show();
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.toString());
		System.exit(0);

	}

	@Override
	public void update(NumberGenerator generator) {
		textGraph.update(generator);
		canvasGraph.update(generator);

	}

}
