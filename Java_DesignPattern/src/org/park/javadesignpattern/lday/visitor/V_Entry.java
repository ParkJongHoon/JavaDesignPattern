package org.park.javadesignpattern.lday.visitor;

import java.util.Iterator;

public abstract class V_Entry implements Element {
	public abstract String getName();
	public abstract int getSize();
	
	// 사이즈를 얻는다.
	public V_Entry add(V_Entry entry) throws FileTreatmentException{
											// 엔트리를 추가한다.
		throw new FileTreatmentException();
	}
	public Iterator iterator() throws FileTreatmentException{	// Iterator의 생성
		throw new FileTreatmentException();
	} 
	
	public String toString(){
		return getName() + " (" + getSize() + ")";
	}

}
