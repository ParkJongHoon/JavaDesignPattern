package org.park.javadesignpattern.mday.chain_of_responsibility;

public abstract class Support {
	
	/**
	 * �ٽ� ����
	 * 1) setNext(Support ����) <- main()�ܿ��� ���������� 
	 * Support chain�� ������ �� �ִ�. Support ������ ��
	 * 
	 * 2) support(Trouble ����) <- ���� ������ Support�� ����Ŭ������
	 * ���� resolve�� true, false ���� ������ �� ����� ���� else if��
	 * else�� �޼ҵ� ������ �����ϴ�.
	 * 
	 * 3) main()���� for���� ���ؼ� ���������� support()�� ���� ��
	 * ������ Support���� setNext�� �����ִ� ���� ���� �޼ҵ����
	 * ���ư���. �׷��� �ش����ǿ� �´� �޼ҵ� Ÿ�� ����.
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
	public String toString() {					// ���ڿ� ǥ��
		return "Support [name=" + name + "]";
	}
	
	protected abstract boolean resolve(Trouble trouble);		//�ذ�� �޼ҵ�
	protected void done(Trouble trouble){			// �ذ�
		System.out.println(trouble + "is resolved by " + this + "." );
	}
	protected void fail(Trouble trouble){			// ���ذ�
		System.out.println(trouble + " cannot be resolved.");
	}
	
}
