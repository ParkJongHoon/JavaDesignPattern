package org.park.javadesignpattern.builder.main;


import org.park.javadesignpattern.builder.HTMLBuilder;
import org.park.javadesignpattern.builder.TextBuilder;
import org.park.javadesignpattern.builder.example.Director;
import org.park.javadesignpattern.builder.example.HTMLBuilderInfa;
import org.park.javadesignpattern.builder.example.TextBuilderInfa;

public class BuilderMain2 {
	/**
	 * 작성일: 2017-05-17
	 * 작성자: 박종훈
	 * 작성내용: Builder pattern
	 * 1) Builder 클래스에 행동패턴에 대한 추상메소드로 정의한다.
	 * 2) Builder 클래스의 추상메소드를 구현할 내용을 Builder클래스를 상속받은 후 구현한다.
	 * -> HTMLBuilder, TextBuilder 클래스이며 ConcreteBuilder역할을 담당한다.
	 * 3) Director 클래스에서 생성자부분에 Builder클래스 객체를 주입하는 부분을 생성하고
	 * 주입받은 객체에 대한 실행계획을 가진을 실행메소드를 만든다.(construct()) 
	 * @param args
	 */

	public static void main(String[] args) {
		if(args.length != 1){
			usage();
			System.exit(0);
		}
		if(args[0].equals("plain")){
			TextBuilderInfa textbuilder = new TextBuilderInfa();
			Director director = new Director(textbuilder);
			director.construct();
			String result = textbuilder.getResult();
			System.out.println(result);
		}else if(args[0].equals("html")){
			HTMLBuilderInfa htmlbuilder = new HTMLBuilderInfa();
			Director director = new Director(htmlbuilder);
			director.construct();
			String filename = htmlbuilder.getResult();
			System.out.println(filename + "가 작성되었습니다");
		}else{
			usage();
			System.exit(0);
		}

	}
	
	public static void usage(){
		System.out.println("Usage: java Main plain 일반 텍스트로 문서작성");
		System.out.println("Usage: java Main html HTML, 파일로 문서작성");
	}

}
