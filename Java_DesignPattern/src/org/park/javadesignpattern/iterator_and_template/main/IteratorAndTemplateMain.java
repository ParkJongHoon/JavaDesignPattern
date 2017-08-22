package org.park.javadesignpattern.iterator_and_template.main;

import org.park.javadesignpattern.iterator_and_template.AbstractIteratorImpi;


public class IteratorAndTemplateMain {

	public static void main(String[] args) {
		
		/*AbstractDisplay d1 = new CharDisplay('H');
		AbstractDisplay d2 = new StringDisplay("Hello, world.");
		AbstractDisplay d3 = new StringDisplay("�ȳ��ϼ���");
		d1.display();
		d2.display();
		d3.display();
		
		Iterator�� �����Ͽ�
		�Է°��� ���� �������� AbstractDisplay �迭 ��ü�� ���� �� ���
		��� �� ��ϵ� ��ü���� �޼ҵ� �ϳ��� �ϰ�����
		*/
		AbstractIteratorImpi aii = new AbstractIteratorImpi();
		aii.enrollAbstractDisplay('H');
		aii.enrollAbstractDisplay("Hello, world");
		aii.enrollAbstractDisplay("�ȳ��ϼ���");
		aii.iteratorAbstractDisplay();
	}

}
