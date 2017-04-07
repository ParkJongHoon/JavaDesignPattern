package org.park.javadesignpattern.adapter.main;

import org.park.javadesignpattern.adapter.delegate.Print;
import org.park.javadesignpattern.adapter.delegate.PrintBanner;



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
