package org.park.javadesignpattern.singleton;

public class TripleMain {
	
	/**
	 * 작성자: 박종훈
	 * 작성일: 2017-05-08
	 * 작성내용: Singleton Pattern 예제2
	 * 			 객체 생성 개수 제한 하는 예제
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
