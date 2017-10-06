package org.park.javadesignpattern.lday.visitor;

public abstract class Visitor {
	/**
	 * visit �޼ҵ��� �����ε�
	 * �������� ���� �޼ҵ带 �����Ͽ� ������
	 * Visitor�� ��ӹ��� Ŭ������ �޼ҵ忡 ���߾
	 * �����Ǵ� ������ �޶���
	 * ������ ������ ���� �и� -> ���ڰ��� ���� ���� �̸��� �޼ҵ� �и�
	 * 
	 */
	public abstract void visit(V_File file);
	public abstract void visit(V_Directory directory);
	
}
