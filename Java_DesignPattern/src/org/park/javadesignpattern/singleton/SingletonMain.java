package org.park.javadesignpattern.singleton;

public class SingletonMain {
	
	/**
	 * �ۼ���: ������
	 * �ۼ���: 2017-05-08
	 * �ۼ�����: Singleton Pattern
	 * �Ʒ� ������ �̿��Ͽ�  �ϳ��� ��ü�� �����ϰ�
	 * private static Singleton singleton = new Singleton();
	 * getSingleton()�� �̿��Ͽ� ������ ��ü�� �����Ѵ�.
	 * 
	 * ���� Ŭ���������� �ش� ��ü�� ������ü�� �ȵ�(private ����)
	 * 
	 */

	public static void main(String[] args) {
		System.out.println("Start. ");
		Singleton obj1 = Singleton.getSingleton();
		Singleton obj2 = Singleton.getSingleton();
		if(obj1 == obj2){
			System.out.println("obj1�� obj2�� ���� �ν��Ͻ��Դϴ�.");
		}else{
			System.out.println("obj1�� obj2�� �ٸ� �ν��Ͻ��Դϴ�.");
		}
		System.out.println("End. ");
	}

}
