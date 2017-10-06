package org.park.javadesignpattern.lday.visitor;

public abstract class Visitor {
	/**
	 * visit 메소드의 오버로딩
	 * 인지값의 따라서 메소드를 구분하여 정의함
	 * Visitor를 상속받은 클래스는 메소드에 맞추어서
	 * 구현되는 내용이 달라짐
	 * 데이터 구조의 의한 분리 -> 인자값에 따른 같은 이름의 메소드 분리
	 * 
	 */
	public abstract void visit(V_File file);
	public abstract void visit(V_Directory directory);
	
}
