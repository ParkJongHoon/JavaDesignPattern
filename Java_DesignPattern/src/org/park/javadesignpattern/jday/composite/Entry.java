package org.park.javadesignpattern.jday.composite;


/**
 * 
 * Composite 패턴의 특징
 * 1) 최상위 객체를 추상클래스로 정의
 * 2) 중간단계 객체를 상속받아서 정의
 * 3) 최하위 객체를 상속받아서 정의
 * 4) 중간단계 객체는 메소드 정의시 재귀내용포함
 * 
 * 해당 객체 풀네임을 얻는 방법
 * 1) Entry 비어있는 객체를 만든후
 * 2) Entry를 상속받은 Directory 객체에서 add() 진행시 this로 객체전달
 * 3) entry.parent가 없을시 do-while문 종료로 StringBuffer로 작성된 풀네임전달
 *
 *--> 결론 풀네임을 얻는 것도 결국 재귀임
 */
public abstract class Entry {
	protected Entry parent;
	public abstract String getName();
	public abstract int getSize();
	public Entry add(Entry entry) throws FileTreatmentException{
		throw new FileTreatmentException();
	}
	public void printList(){
		printList("");
	}
	protected abstract void printList(String prefix);
	public String toString(){
		return getName() + " (" + getSize() + ")";
	}
	
	public String getFullName(){
		StringBuffer fullName = new StringBuffer();
		Entry entry = this;
		do{
			fullName.insert(0, "/" + entry.getName());
			entry = entry.parent;
		}while(entry != null);
		return fullName.toString();
	}
}
