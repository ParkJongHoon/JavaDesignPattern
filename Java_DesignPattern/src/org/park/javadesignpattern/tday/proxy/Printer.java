package org.park.javadesignpattern.tday.proxy;

public class Printer implements Printable {
	private String name;
	public Printer() {
		heavyJob("Printer의 인스턴스를 생성 중");
	}
	
	public Printer(String name){
		this.name = name;
		heavyJob("Printer의 인스턴스 (" + name + ")을 생성 중");
	}

	@Override
	public void setPrinterName(String name) {	// 이름의 설정
		this.name = name;
	}

	@Override
	public String getPrinterName() {			// 이름의 취득
		return name;
	}

	@Override
	public void print(String string) {			// 이름을 붙여서 표시
		System.out.println("=== " + name + " ===");
		System.out.println(string);
	}
	private void heavyJob(String msg){
		System.out.println(msg);
		for(int i = 0; i < 5; i++){
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				
			}
			System.out.println(".");
		}
		System.out.println("완료.");
	}

}
