package org.park.javadesignpattern.kday.decorator;

public abstract class Display {
	/**
	 * 
	 * Display�� ��ӹ޴� Ŭ������ �� show()�� ���߾ ������
	 */
	
	public abstract int getColumns();	// ���� ���ڼ��� ��´�.
	public abstract int getRows();		// ���� ����� ��´�.
	public abstract String getRowText(int row);	//row��°�� ���ڿ��� ��´�.
	public final void show(){
		for(int i =0; i < getRows(); i++){
			System.out.println(getRowText(i));
		}
	}
}
