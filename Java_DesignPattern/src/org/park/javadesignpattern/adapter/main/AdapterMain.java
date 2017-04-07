package org.park.javadesignpattern.adapter.main;

import org.park.javadesignpattern.adapter.Print;
import org.park.javadesignpattern.adapter.PrintBanner;

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
