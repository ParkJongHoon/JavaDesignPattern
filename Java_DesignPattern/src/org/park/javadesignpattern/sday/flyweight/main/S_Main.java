package org.park.javadesignpattern.sday.flyweight.main;

import org.park.javadesignpattern.sday.flyweight.BigString;

/**
 * main 메소드 실행할 때 넣어주는 인자값(숫자로만)에 따라서
 * 큰 문자 console에 찍힘
 * 
 * 전체 제어하는 클래스는 BigString임 
 * 
 * 이 패턴의 의도는 오브젝트(객체)를 '가볍게'하는 것에 목적이
 * 있다. 큰 문자 객체를 사용할 때마다 매번 불러내는 것이 아니라
 * 한번 불러낼 때 Map에 key와 value로 저장후 consolo에 큰문자를
 * 찍고, 동일한 문자를 재호출시 Map객체에서 key로 해당 객체를
 * 가지고와서 consolo에 출력한다. -> 쓸데없이 new 하는 것을 줄임
 */

public class S_Main {
	public static void main(String[] args) {
		if(args.length == 0){
			System.out.println("Usage: java Main digits");
			System.out.println("Example: java Main 1212123");
			System.exit(0);
		}
		BigString bs = new BigString(args[0]);
		bs.print();

	}

}
