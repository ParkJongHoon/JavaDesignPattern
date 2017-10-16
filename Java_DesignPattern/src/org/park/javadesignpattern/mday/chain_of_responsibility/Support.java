package org.park.javadesignpattern.mday.chain_of_responsibility;

public abstract class Support {
	
	/**
	 * 핵심 내용
	 * 1) setNext(Support 변수) <- main()단에서 연쇄적으로 
	 * Support chain을 설정할 수 있다. Support 변수에 넣
	 * 
	 * 2) support(Trouble 변수) <- 현재 설정된 Support의 하위클래스에
	 * 따라서 resolve의 true, false 값이 결정됨 그 결과에 따라서 else if와
	 * else로 메소드 진행이 가능하다.
	 * 
	 * 3) main()에서 for문을 통해서 지속적으로 support()를 돌릴 때
	 * 상위의 Support부터 setNext로 묶여있는 가장 하위 메소드까지
	 * 돌아간다. 그래서 해당조건에 맞는 메소드 타고 들어간다.
	 */
	
	private String name;
	private Support next;
	public Support(String name) {
		this.name = name;
	}
	
	public Support setNext(Support next){
		this.next = next;
		return next;
	}
	
	public final void support(Trouble trouble){
		if(resolve(trouble)){
			done(trouble);
		}else if(next != null){
			next.support(trouble);
		}else{
			fail(trouble);
		}
	}

	@Override
	public String toString() {					// 문자열 표현
		return "Support [name=" + name + "]";
	}
	
	protected abstract boolean resolve(Trouble trouble);		//해결용 메소드
	protected void done(Trouble trouble){			// 해결
		System.out.println(trouble + "is resolved by " + this + "." );
	}
	protected void fail(Trouble trouble){			// 미해결
		System.out.println(trouble + " cannot be resolved.");
	}
	
}
