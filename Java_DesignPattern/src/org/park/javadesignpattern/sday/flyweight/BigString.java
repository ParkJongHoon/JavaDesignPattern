package org.park.javadesignpattern.sday.flyweight;

public class BigString {
	
	// '큰 문자'의 배열
	private BigChar[] bigchars;
	// 생성자
	public BigString(String string){
		bigchars = new BigChar[string.length()];	// 큰 문자 담을 컨테이너 역할
		BigCharFactory factory = BigCharFactory.getInstance();	// 싱글턴 패턴으로 객체를 가지고 온다.
		for(int i = 0; i < bigchars.length; i++){	// 큰 문자를 담을 컨테이너 배열에 배열의 수로 for() 돌림
			bigchars[i] = factory.getBigChar(string.charAt(i));		// 해당 순서에 Map 객체의 value 가지고 온다.
																	// 그러나 해당값이 없을 때 인스턴스 생성해서 넣어줌
		}
	}
	
	public BigString(String string, boolean shared){
		bigchars = new BigChar[string.length()];
		if(shared){
			BigCharFactory factory = BigCharFactory.getInstance();	// 싱글턴 패턴으로 객체를 가지고 온다.
			for(int i = 0; i < bigchars.length; i++){	// 큰 문자를 담을 컨테이너 배열에 배열의 수로 for() 돌림
				bigchars[i] = factory.getBigChar(string.charAt(i));		// 해당 순서에 Map 객체의 value 가지고 온다.															// 그러나 해당값이 없을 때 인스턴스 생성해서 넣어줌
			}	
		}else{
			for(int i = 0; i < bigchars.length; i++){	// 큰 문자를 담을 컨테이너 배열에 배열의 수로 for() 돌림
				bigchars[i] = new BigChar(string.charAt(i));
			}
			
		}
		
	}
	// 표시
	public void print(){
		for(int i =0; i < bigchars.length; i++){	// for문의 순서에 따라서 돌림하여 큰문자 consolo 찍음 
			bigchars[i].print();
		}
	}
}
