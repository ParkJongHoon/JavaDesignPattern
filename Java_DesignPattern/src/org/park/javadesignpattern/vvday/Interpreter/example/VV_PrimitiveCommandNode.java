package org.park.javadesignpattern.vvday.Interpreter.example;

// <primitive command> ::= go | right | left
public class VV_PrimitiveCommandNode extends VV_Node {
	private String name;
	private VV_Executor executor;

	@Override
	public void parse(VV_Context context) throws VV_ParseException {
		name = context.currentToken();
		context.skipToken(name);
		executor = context.createExecutor(name);
	}
	
	@Override
	public void execute() throws VV_ExecuteException {
		if(executor == null){
			throw new VV_ExecuteException(name + ": is not defined"); 
		}else{
			executor.execute();
		}

	}
	@Override
	public String toString() {
		return name;
	}



}
