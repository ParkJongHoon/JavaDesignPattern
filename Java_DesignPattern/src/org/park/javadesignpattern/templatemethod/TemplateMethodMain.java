package org.park.javadesignpattern.templatemethod;

public class TemplateMethodMain {
	
	/**
	 * ����: �����ȹ�� �ֻ����� �߻�Ŭ�������� 
	 * �����ȹ�� ���� �޼ҵ带 final�� ������(����Ŭ�������� ���� ���ϵ���)
	 * ����� ������ �޼ҵ带 ���� �߻�Ŭ�������� �߻�޼ҵ�� ���Ǹ��ϰ�
	 * �� �߻�޼ҵ忡 ���� ������ ����Ŭ���� �����Ѵ�.
	 * �����ȹ�� �����̰�, �����Ǵ� ������ �����ϴ� ����Ŭ������ ����
	 * �޶��� �� �ִ�.
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		AbstractDisplay d1 = new CharDisplay('H');
		AbstractDisplay d2 = new StringDisplay("Hello, world.");
		AbstractDisplay d3 = new StringDisplay("�ȳ��ϼ���");
		d1.display();
		d2.display();
		d3.display();
	}

}
