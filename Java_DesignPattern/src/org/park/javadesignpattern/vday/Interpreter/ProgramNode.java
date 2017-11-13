package org.park.javadesignpattern.vday.Interpreter;

public class ProgramNode extends V_Node {
	private V_Node commandListNode;
	
	@Override
	public void parse(V_Context context) throws ParseException {
		context.skipToken("program");
		commandListNode = new CommandListNode();
		commandListNode.parse(context);
	}
	
	public String toString(){
		return "[program " + commandListNode + "]";
	}

}
