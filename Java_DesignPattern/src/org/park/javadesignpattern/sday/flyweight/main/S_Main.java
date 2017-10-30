package org.park.javadesignpattern.sday.flyweight.main;

import org.park.javadesignpattern.sday.flyweight.BigString;

public class S_Main {
	public static void main(String[] args) {
		if(args.length == 0){
			System.out.println("Usage: java Main digits");
			System.out.println("Example: java Main 1212123");
			System.exit(0);
		}
		BigString bs = new BigString(args[0]);
		bs.print();

	}

}
