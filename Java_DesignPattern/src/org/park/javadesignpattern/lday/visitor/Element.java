package org.park.javadesignpattern.lday.visitor;

public interface Element {
	/**
	 * accept�� ���� �� VisitorŬ������ �ִ� 
	 * visit�޼ҵ带 ����ϴ� ���� 
	 *  
	 */
	public abstract void accept (Visitor v);
}
