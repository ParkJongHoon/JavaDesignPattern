package org.park.javadesignpattern.jday.composite;


/**
 * 
 * Composite ������ Ư¡
 * 1) �ֻ��� ��ü�� �߻�Ŭ������ ����
 * 2) �߰��ܰ� ��ü�� ��ӹ޾Ƽ� ����
 * 3) ������ ��ü�� ��ӹ޾Ƽ� ����
 * 4) �߰��ܰ� ��ü�� �޼ҵ� ���ǽ� ��ͳ�������
 * 
 * �ش� ��ü Ǯ������ ��� ���
 * 1) Entry ����ִ� ��ü�� ������
 * 2) Entry�� ��ӹ��� Directory ��ü���� add() ����� this�� ��ü����
 * 3) entry.parent�� ������ do-while�� ����� StringBuffer�� �ۼ��� Ǯ��������
 *
 *--> ��� Ǯ������ ��� �͵� �ᱹ �����
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
