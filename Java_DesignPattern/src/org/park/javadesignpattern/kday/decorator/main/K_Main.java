package org.park.javadesignpattern.kday.decorator.main;

import org.park.javadesignpattern.kday.decorator.Display;
import org.park.javadesignpattern.kday.decorator.FullBorder;
import org.park.javadesignpattern.kday.decorator.SideBorder;

import tools.dynamiccreate.DynamicObjectCreater;

public class K_Main {

	public static void main(String[] args) {
		Display b1 = (Display)DynamicObjectCreater.newInstanceObject("StringDisplay", "hello, world");
		Display b2 = (Display)DynamicObjectCreater.newInstanceObject("SideBorder", b1, '#');
		Display b3 = (Display)DynamicObjectCreater.newInstanceObject("FullBorder", b2);
		b1.show();
		b2.show();
		b3.show();
		Display b4 = (Display)DynamicObjectCreater.newInstanceObject("SideBorder", 
						(Display)DynamicObjectCreater.newInstanceObject("FullBorder", 
								(Display)DynamicObjectCreater.newInstanceObject("FullBorder", 
										(Display)DynamicObjectCreater.newInstanceObject("SideBorder",
												(Display)DynamicObjectCreater.newInstanceObject("FullBorder",
														(Display)DynamicObjectCreater.newInstanceObject("StringDisplay", "æ»≥Á«œººø‰")
														)
												,'*')
												)
											),		
										'/');
		b4.show();
	}

}
