package org.park.javadesignpattern.adapter.main;

import org.park.javadesignpattern.adapter.delegate.Print;
import org.park.javadesignpattern.adapter.delegate.PrintBanner;



/**
 * 작성일:2017-04-07
 * 작성자: 박종훈
 * 작성내용: Adapter Pattern - 위임을 이용한 방법
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
