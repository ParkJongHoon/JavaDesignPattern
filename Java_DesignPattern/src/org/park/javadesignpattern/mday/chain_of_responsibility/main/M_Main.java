package org.park.javadesignpattern.mday.chain_of_responsibility.main;

import org.park.javadesignpattern.mday.chain_of_responsibility.LimitSupport;
import org.park.javadesignpattern.mday.chain_of_responsibility.NoSupport;
import org.park.javadesignpattern.mday.chain_of_responsibility.OddSupport;
import org.park.javadesignpattern.mday.chain_of_responsibility.SpecialSupport;
import org.park.javadesignpattern.mday.chain_of_responsibility.Support;
import org.park.javadesignpattern.mday.chain_of_responsibility.Trouble;

import tools.dynamiccreate.DynamicObjectCreater;

public class M_Main {

	public static void main(String[] args) {
		Support aliace = (NoSupport)DynamicObjectCreater.newInstanceObject("NoSupport", "Aliace");
		Support bob = (LimitSupport)DynamicObjectCreater.newInstanceObject("LimitSupport", "Bob", 100);
		Support charlie = (SpecialSupport)DynamicObjectCreater.newInstanceObject("SpecialSupport", "Charlie", 429);
		Support diana = (LimitSupport)DynamicObjectCreater.newInstanceObject("LimitSupport", "Diana", 200);
		Support elmo = (OddSupport)DynamicObjectCreater.newInstanceObject("OddSupport", "Elmo");
		Support fred = (LimitSupport)DynamicObjectCreater.newInstanceObject("LimitSupport", "Fred", 300);
		// 사슬의 형성
		aliace.setNext(bob).setNext(charlie).setNext(diana).setNext(elmo).setNext(fred);
		// 다양한 트러블 발생
		for(int i = 0; i < 500; i += 33)
			aliace.support((Trouble)DynamicObjectCreater.newInstanceObject("Trouble", i));
	}

}
