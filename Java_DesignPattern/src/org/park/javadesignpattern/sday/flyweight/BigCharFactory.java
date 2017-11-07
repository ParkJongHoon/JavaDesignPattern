package org.park.javadesignpattern.sday.flyweight;

import java.util.HashMap;

public class BigCharFactory {
	// �̹� ������� BigChar�� �ν��Ͻ��� ����
	private HashMap<String, BigChar> pool = new HashMap<String, BigChar>();
	// singleton ����
	private static BigCharFactory singleton = new BigCharFactory();
	// ������
	private BigCharFactory(){
	}
	
	// ������ �ν��Ͻ��� ��´�.
	public static BigCharFactory getInstance() {
		return singleton;
	}
	
	// BigChar�� �ν��Ͻ� ����(����)
	/*
	 * synchronized�� �ش� �޼ҵ带 ���� �ٸ� �����忡�� �����
	 * Ÿ�ֿ̹� ȣ��� ���� ����� �����忡�� �켱���� �ְ� ���� �����
	 * �����尡 ����� ��ġ�� �ش� �޼ҵ带 ����ϰ� ���ִ� ����
	 * 
	 * -> �� ����ϴ°�? 
	 * �ش� �޼ҵ忡�� ��ü�� �����Ͽ� map ��ü���� �����Ͽ� �����ϴ� ����̶��
	 * ������ ��ü�� �ι� ���� �ʿ䰡 ����. �׷��� synchronized ����� ������
	 * ������ �ٸ� ������ ����� Ÿ�ֿ̹� �ش� �޼ҵ带 ȣ��� ���� ��ü��
	 * �� �� ������ ���ɼ��� �����ϰ� �ȴ�. �̸� ������ 
	 */
	
	public synchronized BigChar getBigChar(char charname){
		BigChar bc = (BigChar)pool.get("" + charname);
		if(bc == null){
			bc = new BigChar(charname);		// ���⿡�� BigChar�� �ν��Ͻ��� ����
			pool.put("" + charname , bc);
		}			
		return bc;
	}
	
	
}
