package org.park.javadesignpattern.aday.adapter.main;

import org.park.javadesignpattern.aday.adapter.Print;
import org.park.javadesignpattern.aday.adapter.PrintBanner;

/**
 * 작성일:2017-04-07
 * 작성자: 박종훈
 * 작성내용: Adapter Pattern - 상속을 이용한 방법
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
