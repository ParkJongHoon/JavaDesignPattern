package org.park.javadesignpattern.tday.proxy.main;

import org.park.javadesignpattern.tday.proxy.Printable;
import org.park.javadesignpattern.tday.proxy.PrinterProxy;

/**
 * �� ���( print() )�� ���� ���( setPrinterName() )���� ����� �����غ��ٸ�
 * �� ����� ���ΰ�ü�� ���� ����� �븮�� ��ü(Proxy��ü)�� ó���Ѵ�.
 * �׷��� ���� ������ü�� ���� �� interface Ÿ������ ����.
 * �׷��� ���� ����� Proxy��ü�� �ϰ� �� ����� ���� �� ����
 * �� ��ü�� �����Ͽ� �����Ѵ�.
 * 
 * Proxy��ü�� �� ����� ȣ���ϸ� �׶� �� ��ü�� �����Ͽ�
 * �����Ѵ�. �׷��� ���ؼ� Proxy��ü �ȿ� �� ��ü�� ���� �� 
 * �ִ� �׸��� �ʿ���
 * 
 */

public class T_Main {

	public static void main(String[] args) {
		Printable p = new PrinterProxy("Alice");
		System.out.println("�̸��� ���� " + p.getPrinterName() + "�Դϴ�");
		p.setPrinterName("Bob");
		System.out.println("�̸��� ���� " + p.getPrinterName() + "�Դϴ�.");
		p.print("Hello, world");

	}

}
