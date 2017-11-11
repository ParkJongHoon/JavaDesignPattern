package org.park.javadesignpattern.tday.proxy;

import tools.dynamiccreate.DynamicObjectCreater;

public class PrinterProxy implements Printable {
	private String name;			// 이름
	private Printer real;			// '본인'
	public PrinterProxy() {}
	public PrinterProxy(String name){	// 생성자
		this.name = name;
	}

	@Override
	public synchronized void setPrinterName(String name) {		// 이름의 설정
		if(real != null){
			real.setPrinterName(name); 		// '본인'에게도 설정한다.
		}
		this.name = name;
	}

	@Override
	public String getPrinterName() {		// 이름의 설정
		return name;
	}

	@Override
	public void print(String string) {
		realize();
		real.print(string);
	}
	
	private synchronized void realize(){	// '본인'을 생성
		/**
		 *	Proxy 객체가 가지고 있는 정보를 본인 객체 생성시
		 *	넣어준다.(setter 방식으로나 construct 방식으로나) 
		 */
		if(real == null){
			real = (Printer)DynamicObjectCreater.newInstanceObject("Printer", name);
		}
	}

}
