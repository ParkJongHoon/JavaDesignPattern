package org.park.javadesignpattern.tday.proxy.main;

import org.park.javadesignpattern.tday.proxy.Printable;
import org.park.javadesignpattern.tday.proxy.PrinterProxy;

/**
 * 본 기능( print() )과 보조 기능( setPrinterName() )으로 나누어서 생각해본다면
 * 본 기능은 본인객체가 보조 기능은 대리인 객체(Proxy객체)가 처리한다.
 * 그래서 먼저 보조객체가 생성 후 interface 타입으로 들어간다.
 * 그래서 보조 기능은 Proxy객체가 하고 본 기능을 수행 할 때는
 * 본 객체를 생성하여 진행한다.
 * 
 * Proxy객체에 본 기능을 호출하면 그때 본 객체를 생성하여
 * 진행한다. 그렇기 위해서 Proxy객체 안에 본 객체를 담을 수 
 * 있는 그릇이 필요함
 * 
 */

public class T_Main {

	public static void main(String[] args) {
		Printable p = new PrinterProxy("Alice");
		System.out.println("이름은 현재 " + p.getPrinterName() + "입니다");
		p.setPrinterName("Bob");
		System.out.println("이름은 현재 " + p.getPrinterName() + "입니다.");
		p.print("Hello, world");

	}

}
