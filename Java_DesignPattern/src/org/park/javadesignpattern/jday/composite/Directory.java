package org.park.javadesignpattern.jday.composite;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 
 * Composite pattern의 핵심 2가지
 * 1. ArrayList로 Entry 계열의 클래스들을 담는다.
 * 2. Entry에서 정의 메소드들을 사용할 때 ArrayList에서 Iterator로 
 *    만든후 while(hasNest())를 이용하여 하나씩 정의한 메소드를 재귀로 불러다쓴다.
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
		// size는 디렉토리의 크기
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
		// 여기서 this는 Directory의 superclass에서 정의한 toString메소드내용을 출력한다.
		System.out.println(prefix + "/" + this);
		Iterator it = directory.iterator();
		while(it.hasNext()){
			Entry entry = (Entry)it.next();
			// prefix + "/" + name를 인자값으로 넘겨주어서 printList 재기메소드작동
			entry.printList(prefix + "/" + name);
		}

	}
	

}
