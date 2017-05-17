package org.park.javadesignpattern.builder.example;

public class Director {
	private BuilderInfa builder;
	public Director(BuilderInfa builder){
		this.builder = builder;
	}
	public void construct(){
		builder.makeTitle("Greeting");
		builder.makeString("아침과 낮에");
		builder.makeItems(new String[]{
				"좋은 아침입니다.",
				"안녕하세요",
		});
		builder.makeString("밤에");
		builder.makeItems(new String[]{
				"안녕하세요.",
				"안녕히 주무세요.",
				"안녕히 계세요.",
		});
		builder.close();
	}

}
