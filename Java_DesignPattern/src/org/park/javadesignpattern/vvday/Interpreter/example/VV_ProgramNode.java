package org.park.javadesignpattern.vvday.Interpreter.example;

// <program> ::= program <command list>
public class VV_ProgramNode extends VV_Node {
	private VV_Node commandListNode;
	
	@Override
	public void parse(VV_Context context) throws VV_ParseException {
		context.skipToken("program");
		commandListNode = new VV_CommandListNode();
		commandListNode.parse(context);
	}
	
	
	@Override
	public void execute() throws VV_ExecuteException {
		commandListNode.execute();

	}
	
	@Override
	public String toString() {
		return "[program " + commandListNode + "]";
	}

	

}
