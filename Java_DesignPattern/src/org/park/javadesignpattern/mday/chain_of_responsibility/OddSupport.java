package org.park.javadesignpattern.mday.chain_of_responsibility;

public class OddSupport extends Support {

	public OddSupport(String name) {
		super(name);
	}
	
	@Override
	protected boolean resolve(Trouble trouble) {
		if(trouble.getNumber() % 2 == 1){
			return true;
		}else{
			return false;
		}
	}

}
