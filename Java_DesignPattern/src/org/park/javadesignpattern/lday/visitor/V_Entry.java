package org.park.javadesignpattern.lday.visitor;

import java.util.Iterator;

public abstract class V_Entry implements Element {
	public abstract String getName();
	public abstract int getSize();
	
	// ����� ��´�.
	public V_Entry add(V_Entry entry) throws FileTreatmentException{
											// ��Ʈ���� �߰��Ѵ�.
		throw new FileTreatmentException();
	}
	public Iterator iterator() throws FileTreatmentException{	// Iterator�� ����
		throw new FileTreatmentException();
	} 
	
	public String toString(){
		return getName() + " (" + getSize() + ")";
	}

}
