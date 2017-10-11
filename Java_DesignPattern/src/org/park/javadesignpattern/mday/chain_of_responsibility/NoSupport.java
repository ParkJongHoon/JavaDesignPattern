package org.park.javadesignpattern.mday.chain_of_responsibility;

public class NoSupport extends Support {
	
	public NoSupport(String name) {
		super(name);
	}

	@Override
	protected boolean resolve(Trouble trouble) {		// 해결용 메소드
		return false;									// 자신은 아무것도 처리하지 않는다.
	}

}
