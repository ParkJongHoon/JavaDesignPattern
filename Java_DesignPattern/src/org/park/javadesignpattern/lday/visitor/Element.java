package org.park.javadesignpattern.lday.visitor;

public interface Element {
	/**
	 * accept를 정의 후 Visitor클래스에 있는 
	 * visit메소드를 사용하는 형태 
	 *  
	 */
	public abstract void accept (Visitor v);
}
