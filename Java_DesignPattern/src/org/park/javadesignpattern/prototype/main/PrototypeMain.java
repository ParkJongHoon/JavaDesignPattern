package org.park.javadesignpattern.prototype.main;

import org.park.javadesignpattern.prototype.framework.Manager;
import org.park.javadesignpattern.prototype.framework.Product;
import org.park.javadesignpattern.prototype.impl.MessageBox;
import org.park.javadesignpattern.prototype.impl.UnderlinePen;

public class PrototypeMain {

	public static void main(String[] args) {
		/**
		 * 
		 * 1. Manager는 Product 인터페이스를 구현한 클래스를
		 * 저장 및 복사한 내용을 넘겨주는 역할
		 * 
		 * 2. Product 인터페이스는 실행계획을 추상적인 정의만함
		 * 
		 * 3. Product 인터페이스를 구현한 UnderlinePen, MessageBox
		 *    클래스는 실행계획을 구체화 한다.
		 *    
		 * 4. 객체 생성은 Manager 객체 내부에 있는 HashMap 자료구조에서
		 *    key 값으로 얻어와서 복사하여 넘겨준다. 해당 객체 type은
		 *    Product 인터페이스로 받는다.
		 *    
		 * 5. Product의 use() 실행은 Product 클래스를 구체화 시킨 클래스를
		 *    실행한다.  
		 */
		
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
