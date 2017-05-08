package org.park.javadesignpattern.singleton;

public class TicketMakerMain {
	
	/**
	 * �ۼ���: ������
	 * �ۼ���: 2017-05-08
	 * �ۼ�����: SingleTon ���� 1
	 * 1) ��ü �ϳ��� ������
	 * 2) �ش� ��ü�� �θ������� ���� ����
	 */

	public static void main(String[] args) {
		System.out.println("start.");
		for(int i =0; i<10; i++){
			System.out.println(i + " : " +
			TicketMaker.getTicketMaker().getNextTicketNumber() );
		}
		System.out.println("End. ");
		

	}

}
