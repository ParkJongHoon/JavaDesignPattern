package org.park.javadesignpattern.sday.flyweight;

public class BigString {
	
	// 'ū ����'�� �迭
	private BigChar[] bigchars;
	// ������
	public BigString(String string){
		bigchars = new BigChar[string.length()];	// ū ���� ���� �����̳� ����
		BigCharFactory factory = BigCharFactory.getInstance();	// �̱��� �������� ��ü�� ������ �´�.
		for(int i = 0; i < bigchars.length; i++){	// ū ���ڸ� ���� �����̳� �迭�� �迭�� ���� for() ����
			bigchars[i] = factory.getBigChar(string.charAt(i));		// �ش� ������ Map ��ü�� value ������ �´�.
																	// �׷��� �ش簪�� ���� �� �ν��Ͻ� �����ؼ� �־���
		}
	}
	
	public BigString(String string, boolean shared){
		bigchars = new BigChar[string.length()];
		if(shared){
			BigCharFactory factory = BigCharFactory.getInstance();	// �̱��� �������� ��ü�� ������ �´�.
			for(int i = 0; i < bigchars.length; i++){	// ū ���ڸ� ���� �����̳� �迭�� �迭�� ���� for() ����
				bigchars[i] = factory.getBigChar(string.charAt(i));		// �ش� ������ Map ��ü�� value ������ �´�.															// �׷��� �ش簪�� ���� �� �ν��Ͻ� �����ؼ� �־���
			}	
		}else{
			for(int i = 0; i < bigchars.length; i++){	// ū ���ڸ� ���� �����̳� �迭�� �迭�� ���� for() ����
				bigchars[i] = new BigChar(string.charAt(i));
			}
			
		}
		
	}
	// ǥ��
	public void print(){
		for(int i =0; i < bigchars.length; i++){	// for���� ������ ���� �����Ͽ� ū���� consolo ���� 
			bigchars[i].print();
		}
	}
}
