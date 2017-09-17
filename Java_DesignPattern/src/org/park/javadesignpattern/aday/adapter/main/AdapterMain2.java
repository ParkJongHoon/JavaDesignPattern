package org.park.javadesignpattern.aday.adapter.main;

import org.park.javadesignpattern.aday.adapter.delegate.Print;
import org.park.javadesignpattern.aday.adapter.delegate.PrintBanner;



/**
 * �ۼ���:2017-04-07
 * �ۼ���: ������
 * �ۼ�����: Adapter Pattern - ������ �̿��� ���
 *
 *
 */

public class AdapterMain2 {
	public static void main(String[] args) {
		Print print = new PrintBanner("Hello World");
		print.printStrong();
		print.printWeak();
	}

}
