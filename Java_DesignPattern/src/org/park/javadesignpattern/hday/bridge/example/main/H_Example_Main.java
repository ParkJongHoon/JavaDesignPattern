package org.park.javadesignpattern.hday.bridge.example.main;

import org.park.javadesignpattern.hday.bridge.CountDisplay;
import org.park.javadesignpattern.hday.bridge.FileDisplayImpl;

import tools.dynamiccreate.DynamicObjectCreater;

public class H_Example_Main {

	public static void main(String[] args) {
		CountDisplay d = (CountDisplay)DynamicObjectCreater.newInstanceObject("CountDisplay", 
				(FileDisplayImpl)DynamicObjectCreater.newInstanceObject("FileDisplayImpl", "star.txt"));
		d.multiDisplay(3);

	}

}
