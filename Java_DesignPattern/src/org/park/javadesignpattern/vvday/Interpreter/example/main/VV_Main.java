package org.park.javadesignpattern.vvday.Interpreter.example.main;

import java.awt.*;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import org.park.javadesignpattern.vvday.Interpreter.example.VV_InterpreterFacade;
import org.park.javadesignpattern.vvday.Interpreter.example.VV_TurtleCanvas;

public class VV_Main extends Frame implements ActionListener {
	private VV_TurtleCanvas canvas = new VV_TurtleCanvas(400, 400);
	private VV_InterpreterFacade facade = new VV_InterpreterFacade(canvas);
	private TextField programTextField = new TextField("program repeat 4 go right go left go left end end");

	// 생성자
	public VV_Main(String title) {
		super(title);
		canvas.setExecutor(facade);
		setLayout(new BorderLayout());
		programTextField.addActionListener(this);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		
		add(programTextField, BorderLayout.NORTH);
		add(canvas, BorderLayout.CENTER);
		pack();
		parseAndExecute();
		show();
	}
	
	// ActionListener용
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == programTextField){
			parseAndExecute();
		}
		
	}
	
	private void parseAndExecute(){
		String programText = programTextField.getText();
		facade.parse(programText);
		canvas.repaint();
	}
	
	public static void main(String[] args) {
		new VV_Main("Interpreter Pattern Sample");
	}



}
