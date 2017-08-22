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
			System.out.println(filename + "�� �ۼ��Ǿ����ϴ�");
		}else{
			usage();
			System.exit(0);
		}
		
		
	}
	
	public void usage(){
		System.out.println("Usage: java Main plain �Ϲ� �ؽ�Ʈ�� �����ۼ�");
		System.out.println("Usage: java Main html HTML, ���Ϸ� �����ۼ�");
	}
}
