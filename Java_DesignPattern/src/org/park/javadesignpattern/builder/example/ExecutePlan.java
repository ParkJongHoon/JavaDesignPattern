package org.park.javadesignpattern.builder.example;

public class ExecutePlan {

	private Director director;
	private BuilderInfa builderInfa;
	private InstanceManager instanceManager;
	
	public ExecutePlan(InstanceManager instanceManager) {
		this.director = instanceManager.getDirector();
		this.instanceManager = instanceManager;
	}
	
	public void execute(String[] args){
		if(args.length != 1){
			usage();
			System.exit(0);
		}
		if(args[0].equals("plain")){
			builderInfa = instanceManager.getTextbuilder();
			director.setBuilder(builderInfa);
			director.construct();
			String result = builderInfa.getResult();
			System.out.println(result);
		}else if(args[0].equals("html")){
			builderInfa = instanceManager.getHtmlbuilder();
			director.setBuilder(builderInfa);
			director.construct();
			String filename = builderInfa.getResult();
			System.out.println(filename + "가 작성되었습니다");
		}else{
			usage();
			System.exit(0);
		}
		
		
	}
	
	public void usage(){
		System.out.println("Usage: java Main plain 일반 텍스트로 문서작성");
		System.out.println("Usage: java Main html HTML, 파일로 문서작성");
	}
}
