package org.park.javadesignpattern.tday.proxy.main;

import org.park.javadesignpattern.tday.proxy.Printable;
import org.park.javadesignpattern.tday.proxy.PrinterProxy;

public class T_Main {

	public static void main(String[] args) {
		Printable p = new PrinterProxy("Alice");
		System.out.println("�̸��� ���� " + p.getPrinterName() + "�Դϴ�");
		p.setPrinterName("Bob");
		System.out.println("�̸��� ���� " + p.getPrinterName() + "�Դϴ�.");
		p.print("Hello, world");

	}

}
