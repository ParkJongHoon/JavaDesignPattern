package org.park.javadesignpattern.mday.chain_of_responsibility;

public abstract class Support {
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
