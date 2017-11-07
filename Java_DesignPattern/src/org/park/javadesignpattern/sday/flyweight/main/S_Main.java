package org.park.javadesignpattern.sday.flyweight.main;

import org.park.javadesignpattern.sday.flyweight.BigString;

import tools.dynamiccreate.DynamicObjectCreater;
import tools.runtime.RunTimeCheck;

/**
 * main �޼ҵ� ������ �� �־��ִ� ���ڰ�(���ڷθ�)�� ����
 * ū ���� console�� ����
 * 
 * ��ü �����ϴ� Ŭ������ BigString�� 
 * 
 * �� ������ �ǵ��� ������Ʈ(��ü)�� '������'�ϴ� �Ϳ� ������
 * �ִ�. ū ���� ��ü�� ����� ������ �Ź� �ҷ����� ���� �ƴ϶�
 * �ѹ� �ҷ��� �� Map�� key�� value�� ������ consolo�� ū���ڸ�
 * ���, ������ ���ڸ� ��ȣ��� Map��ü���� key�� �ش� ��ü��
 * ������ͼ� consolo�� ����Ѵ�. -> �������� new �ϴ� ���� ����
 * 
 * Map ��ü�� ����� ��ü�� garbage collection ���� �ʴ´�.
 * �� Map ��ü�� ������� ������ ����ִ� ��ü�� ������ ��
 * 
 * new Ŭ���� �����ð� < Map ��ü�� ����ִ� ��ü ���ð� 
 */

/**
 * true�̸� map ��ü���� 
 * �� ��ü ���� �� ��°���,
 * false�̸� ȣ�⸶�� ����
 * 
 * new�� ��ü ������
 * 
 * true ��� �޸�= 550416
 * false ��� �޸�= 561816
 * 
 * ���÷��� ������� ��ü ������
 *
 * true ��� �޸�= 597928
 * false ��� �޸�= 609256
 */

public class S_Main {
	public static void main(String[] args) {
		if(args.length == 0){
			System.out.println("Usage: java Main digits");
			System.out.println("Example: java Main 1212123");
			System.exit(0);
		}
		// BigString bs = new BigString(args[0], false);
		BigString bs = (BigString)DynamicObjectCreater.newInstanceObject("BigString", args[0], true);
		bs.print();
		
		// �޸� �Һ� �� ���
		DynamicObjectCreater.newInstanceObject("RunTimeCheck");

	}

}
