package org.park.javadesignpattern.mday.chain_of_responsibility;

public class NoSupport extends Support {
	
	public NoSupport(String name) {
		super(name);
	}

	@Override
	protected boolean resolve(Trouble trouble) {		// �ذ�� �޼ҵ�
		return false;									// �ڽ��� �ƹ��͵� ó������ �ʴ´�.
	}

}
