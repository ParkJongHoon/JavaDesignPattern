package org.park.javadesignpattern.prototype.framework;

public abstract class ConCreateProduct implements Product{
	
	/**
	 * 공통 메소드를 abstract class에서 구현한다.
	 * 
	 * 인터페이스 프레임워크에서 정의 
	 * -> abstract class에서 implement 후 공통 메소드를 구현
	 * -> 일반 클래스에서 인터페이스에서 정의한 개별 메소드 구현
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
