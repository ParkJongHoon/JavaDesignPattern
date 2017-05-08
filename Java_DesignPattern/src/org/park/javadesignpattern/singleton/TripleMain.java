package org.park.javadesignpattern.singleton;

public class TripleMain {
	
	/**
	 * �ۼ���: ������
	 * �ۼ���: 2017-05-08
	 * �ۼ�����: Singleton Pattern ����2
	 * 			 ��ü ���� ���� ���� �ϴ� ����
	 */

	public static void main(String[] args) {
		System.out.println("Start.");
		for(int i =0; i<10; i ++){
			Triple triple = Triple.getInstance(i % 3);
			System.out.println(i + ": " + triple);
		}
		System.out.println("End. ");

	}

}
