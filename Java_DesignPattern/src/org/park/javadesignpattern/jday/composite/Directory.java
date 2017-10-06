package org.park.javadesignpattern.jday.composite;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 
 * Composite pattern�� �ٽ� 2����
 * 1. ArrayList�� Entry �迭�� Ŭ�������� ��´�.
 * 2. Entry���� ���� �޼ҵ���� ����� �� ArrayList���� Iterator�� 
 *    ������ while(hasNest())�� �̿��Ͽ� �ϳ��� ������ �޼ҵ带 ��ͷ� �ҷ��پ���.
 *
 */

public class Directory extends Entry {
	private String name;
	private ArrayList directory = new ArrayList();
	public Directory(String name){
		this.name = name;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getSize() {
		// size�� ���丮�� ũ��
		int size = 0;
		Iterator it = directory.iterator();
		while(it.hasNext()){
			Entry entry = (Entry)it.next();
			size += entry.getSize();
		}
		return size;
	}
	public Entry add(Entry entry){
		directory.add(entry);
		entry.parent = this;
		return this;
	}

	@Override
	protected void printList(String prefix) {
		// ���⼭ this�� Directory�� superclass���� ������ toString�޼ҵ峻���� ����Ѵ�.
		System.out.println(prefix + "/" + this);
		Iterator it = directory.iterator();
		while(it.hasNext()){
			Entry entry = (Entry)it.next();
			// prefix + "/" + name�� ���ڰ����� �Ѱ��־ printList ���޼ҵ��۵�
			entry.printList(prefix + "/" + name);
		}

	}
	

}
