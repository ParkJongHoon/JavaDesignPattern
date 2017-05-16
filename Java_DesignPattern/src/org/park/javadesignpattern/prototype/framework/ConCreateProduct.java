package org.park.javadesignpattern.prototype.framework;

public abstract class ConCreateProduct implements Product{
	
	/**
	 * ���� �޼ҵ带 abstract class���� �����Ѵ�.
	 * 
	 * �������̽� �����ӿ�ũ���� ���� 
	 * -> abstract class���� implement �� ���� �޼ҵ带 ����
	 * -> �Ϲ� Ŭ�������� �������̽����� ������ ���� �޼ҵ� ����
	 * 
	 */
	
	public Product createClone() {
		Product p = null;
		try{
			p = (Product)clone();
		}catch(CloneNotSupportedException e){
			e.printStackTrace();
		}
		return p;
	}
	

}
