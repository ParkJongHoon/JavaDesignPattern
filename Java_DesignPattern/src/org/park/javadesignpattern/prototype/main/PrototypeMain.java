package org.park.javadesignpattern.prototype.main;

import org.park.javadesignpattern.prototype.framework.Manager;
import org.park.javadesignpattern.prototype.framework.Product;
import org.park.javadesignpattern.prototype.impl.MessageBox;
import org.park.javadesignpattern.prototype.impl.UnderlinePen;

public class PrototypeMain {

	public static void main(String[] args) {
		// 준비
		Manager manager = new Manager();
		UnderlinePen upen = new UnderlinePen('~');
		MessageBox mbox = new MessageBox('*');
		MessageBox sbox = new MessageBox('/');
		manager.register("strong message", upen);
		manager.register("warning box", mbox);
		manager.register("slash box", sbox);
		
		// 생성
		Product p1 = manager.create("strong message");
		p1.use("Hello, world.");
		Product p2 = manager.create("warning box");
		p2.use("Hello, world.");
		Product p3 = manager.create("slash box");
		p3.use("Hello, world.");

	}

}
