package org.park.javadesignpattern.tday.proxy;

import tools.dynamiccreate.DynamicObjectCreater;

public class PrinterProxy implements Printable {
	private String name;			// �̸�
	private Printer real;			// '����'
	public PrinterProxy() {}
	public PrinterProxy(String name){	// ������
		this.name = name;
	}

	@Override
	public synchronized void setPrinterName(String name) {		// �̸��� ����
		if(real != null){
			real.setPrinterName(name); 		// '����'���Ե� �����Ѵ�.
		}
		this.name = name;
	}

	@Override
	public String getPrinterName() {		// �̸��� ����
		return name;
	}

	@Override
	public void print(String string) {
		realize();
		real.print(string);
	}
	
	private synchronized void realize(){	// '����'�� ����
		/**
		 *	Proxy ��ü�� ������ �ִ� ������ ���� ��ü ������
		 *	�־��ش�.(setter ������γ� construct ������γ�) 
		 */
		if(real == null){
			real = (Printer)DynamicObjectCreater.newInstanceObject("Printer", name);
		}
	}

}
