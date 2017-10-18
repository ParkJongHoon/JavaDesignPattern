package org.park.javadesignpattern.oday.mediator.main;

import org.park.javadesignpattern.oday.mediator.LoginFrame;

import tools.dynamiccreate.DynamicObjectCreater;

public class O_Main {

	public static void main(String[] args) {
		DynamicObjectCreater.newInstanceObject("LoginFrame", "Mediator sample");

	}

}
