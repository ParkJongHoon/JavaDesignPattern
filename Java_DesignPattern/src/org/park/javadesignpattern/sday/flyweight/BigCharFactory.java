package org.park.javadesignpattern.sday.flyweight;

import java.util.HashMap;

public class BigCharFactory {
	// 이미 만들어진 BigChar의 인스턴스를 관리
	private HashMap<String, BigChar> pool = new HashMap<String, BigChar>();
	// singleton 패턴
	private static BigCharFactory singleton = new BigCharFactory();
	// 생성자
	private BigCharFactory(){
	}
	
	// 유일한 인스턴스를 얻는다.
	public static BigCharFactory getInstance() {
		return singleton;
	}
	
	// BigChar의 인스턴스 생성(공유)
	/*
	 * synchronized은 해당 메소드를 각각 다른 스레드에서 비슷한
	 * 타이밍에 호출시 먼저 사용한 스레드에게 우선권을 주고 먼저 사용한
	 * 스레드가 사용을 마치면 해당 메소드를 사용하게 해주는 설정
	 * 
	 * -> 왜 사용하는가? 
	 * 해당 메소드에서 객체를 생성하여 map 객체에서 저장하여 관리하는 기능이라면
	 * 동일한 객체를 두번 넣을 필요가 없다. 그러나 synchronized 기능을 붙이지
	 * 않으면 다른 스레드 비슷한 타이밍에 해당 메소드를 호출시 같은 객체를
	 * 두 번 생성할 가능성이 존재하게 된다. 이를 방지함 
	 */
	
	public synchronized BigChar getBigChar(char charname){
		BigChar bc = (BigChar)pool.get("" + charname);
		if(bc == null){
			bc = new BigChar(charname);		// 여기에서 BigChar의 인스턴스를 생성
			pool.put("" + charname , bc);
		}			
		return bc;
	}
	
	
}
