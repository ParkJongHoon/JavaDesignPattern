package org.park.javadesignpattern.sday.flyweight.main;

import org.park.javadesignpattern.sday.flyweight.BigString;

import tools.dynamiccreate.DynamicObjectCreater;
import tools.runtime.RunTimeCheck;

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
 * 
 * Map 객체에 담겨진 객체는 garbage collection 되지 않는다.
 * 즉 Map 객체가 사라지지 않으면 담고있는 객체도 유지가 됨
 * 
 * new 클래스 생성시간 < Map 객체에 담겨있는 객체 사용시간 
 */

/**
 * true이면 map 객체에서 
 * 각 객체 저장 및 출력관리,
 * false이면 호출마다 생성
 * 
 * new로 객체 생성시
 * 
 * true 사용 메모리= 550416
 * false 사용 메모리= 561816
 * 
 * 리플래시 기능으로 객체 생성시
 *
 * true 사용 메모리= 597928
 * false 사용 메모리= 609256
 */

public class S_Main {
	public static void main(String[] args) {
		if(args.length == 0){
			System.out.println("Usage: java Main digits");
			System.out.println("Example: java Main 1212123");
			System.exit(0);
		}
		// BigString bs = new BigString(args[0], false);
		BigString bs = (BigString)DynamicObjectCreater.newInstanceObject("BigString", args[0], true);
		bs.print();
		
		// 메모리 소비량 비교 기능
		DynamicObjectCreater.newInstanceObject("RunTimeCheck");

	}

}
