package org.park.javadesignpattern.hday.bridge.main;

import org.park.javadesignpattern.hday.bridge.CountDisplay;
import org.park.javadesignpattern.hday.bridge.Display;
import org.park.javadesignpattern.hday.bridge.RandomDisplay;
import org.park.javadesignpattern.hday.bridge.StringDisplayImpl;

import tools.dynamiccreate.DynamicObjectCreater;

public class H_Main {

	public static void main(String[] args) {
		/*
		Display d1 = (Display)DynamicObjectCreater.newInstanceObject("Display", 
				(StringDisplayImpl)DynamicObjectCreater.newInstanceObject("StringDisplayImpl", "Hello, Korea."));
		Display d2 = (CountDisplay)DynamicObjectCreater.newInstanceObject("CountDisplay", 
				(StringDisplayImpl)DynamicObjectCreater.newInstanceObject("StringDisplayImpl", "Hello, World."));
		CountDisplay d3 = (CountDisplay)DynamicObjectCreater.newInstanceObject("CountDisplay", 
				(StringDisplayImpl)DynamicObjectCreater.newInstanceObject("StringDisplayImpl", "Hello, Universe."));
				*/
		RandomDisplay d4 = (RandomDisplay)DynamicObjectCreater.newInstanceObject("RandomDisplay", 
				(StringDisplayImpl)DynamicObjectCreater.newInstanceObject("StringDisplayImpl", "Hello, Universe."));

		d4.randomDisplay(10);
		
	}

}
