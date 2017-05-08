package org.park.javadesignpattern.singleton;

public class TicketMakerMain {
	
	/**
	 * 작성자: 박종훈
	 * 작성일: 2017-05-08
	 * 작성내용: SingleTon 예제 1
	 * 1) 객체 하나만 생성후
	 * 2) 해당 객체를 부를때마다 숫자 증가
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
