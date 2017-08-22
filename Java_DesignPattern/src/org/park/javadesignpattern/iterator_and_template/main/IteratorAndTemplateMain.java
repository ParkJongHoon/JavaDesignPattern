package org.park.javadesignpattern.iterator_and_template.main;

import org.park.javadesignpattern.iterator_and_template.AbstractIteratorImpi;


public class IteratorAndTemplateMain {

	public static void main(String[] args) {
		
		/*AbstractDisplay d1 = new CharDisplay('H');
		AbstractDisplay d2 = new StringDisplay("Hello, world.");
		AbstractDisplay d3 = new StringDisplay("안녕하세요");
		d1.display();
		d2.display();
		d3.display();
		
		Iterator를 적용하여
		입력값에 따라 동적으로 AbstractDisplay 계열 객체를 선택 후 등록
		등록 후 등록된 객체들을 메소드 하나로 일괄실행
		*/
		AbstractIteratorImpi aii = new AbstractIteratorImpi();
		aii.enrollAbstractDisplay('H');
		aii.enrollAbstractDisplay("Hello, world");
		aii.enrollAbstractDisplay("안녕하세요");
		aii.iteratorAbstractDisplay();
	}

}
