package org.park.javadesignpattern.mday.chain_of_responsibility;

public class SpecialSupport extends Support {
	private int number;
	public SpecialSupport(String name) {
		super(name);
	}

	@Override
	protected boolean resolve(Trouble trouble) {
		if(trouble.getNumber() == number){
			return true;
		}else{
			return false;
		}
	}

}
