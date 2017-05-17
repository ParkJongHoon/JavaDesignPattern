package org.park.javadesignpattern.builder.main;


import org.park.javadesignpattern.builder.HTMLBuilder;
import org.park.javadesignpattern.builder.TextBuilder;
import org.park.javadesignpattern.builder.example.Director;
import org.park.javadesignpattern.builder.example.HTMLBuilderInfa;
import org.park.javadesignpattern.builder.example.TextBuilderInfa;

public class BuilderMain2 {
	/**
	 * �ۼ���: 2017-05-17
	 * �ۼ���: ������
	 * �ۼ�����: Builder pattern
	 * 1) Builder Ŭ������ �ൿ���Ͽ� ���� �߻�޼ҵ�� �����Ѵ�.
	 * 2) Builder Ŭ������ �߻�޼ҵ带 ������ ������ BuilderŬ������ ��ӹ��� �� �����Ѵ�.
	 * -> HTMLBuilder, TextBuilder Ŭ�����̸� ConcreteBuilder������ ����Ѵ�.
	 * 3) Director Ŭ�������� �����ںκп� BuilderŬ���� ��ü�� �����ϴ� �κ��� �����ϰ�
	 * ���Թ��� ��ü�� ���� �����ȹ�� ������ ����޼ҵ带 �����.(construct()) 
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
			System.out.println(filename + "�� �ۼ��Ǿ����ϴ�");
		}else{
			usage();
			System.exit(0);
		}

	}
	
	public static void usage(){
		System.out.println("Usage: java Main plain �Ϲ� �ؽ�Ʈ�� �����ۼ�");
		System.out.println("Usage: java Main html HTML, ���Ϸ� �����ۼ�");
	}

}
