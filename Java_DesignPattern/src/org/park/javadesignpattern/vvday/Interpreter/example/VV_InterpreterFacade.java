package org.park.javadesignpattern.vvday.Interpreter.example;

public class VV_InterpreterFacade implements VV_Executor {
	private VV_ExecutorFactory factory;
	private VV_Context context;
	private VV_Node programNode;
	public VV_InterpreterFacade(VV_ExecutorFactory factory) {
		this.factory = factory;
	}
	
	public boolean parse(String text){
		boolean ok = true;
		this.context = new VV_Context(text);
		this.context.setExecutorFactory(factory);
		this.programNode = new VV_ProgramNode();
		try{
			programNode.parse(context);
			System.out.println(programNode.toString());
			
		}catch(VV_ParseException e){
			e.printStackTrace();
			ok = false;
		}
		return ok;
	}

	@Override
	public void execute() throws VV_ExecuteException {
		try{
			programNode.execute();
		}catch(VV_ExecuteException e){
				e.printStackTrace();
		}

	}

}
