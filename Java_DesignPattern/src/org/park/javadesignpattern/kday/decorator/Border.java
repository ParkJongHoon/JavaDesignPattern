package org.park.javadesignpattern.kday.decorator;

public abstract class Border extends Display {
	protected Display display;		// �� ����� �ѷ��ΰ� �ִ� '���빰'
	protected Border(Display display){	// �ν��Ͻ� �����ÿ� '���빰'�� �μ��� ����
		this.display = display;
	}
}
