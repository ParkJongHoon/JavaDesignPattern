package org.park.javadesignpattern.adapter.main;

import org.park.javadesignpattern.adapter.Print;
import org.park.javadesignpattern.adapter.PrintBanner;

/**
 * �ۼ���:2017-04-07
 * �ۼ���: ������
 * �ۼ�����: Adapter Pattern - ����� �̿��� ���
 *
 *
 */

public class AdapterMain {
	public static void main(String[] args) {
		Print print = new PrintBanner("Hello World");
		print.printStrong();
		print.printWeak();
	}

}
