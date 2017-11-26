package org.park.javadesignpattern.vvday.Interpreter.example;

public class VV_RepeatCommandNode extends VV_Node {
	private int  number;
	private VV_Node commandListNode;
	@Override
	public void parse(VV_Context context) throws VV_ParseException {
		context.skipToken("repeat");
		number = context.currentNumber();
		context.nextToken();
		commandListNode = new VV_CommandListNode();
		commandListNode.parse(context);
	}
	@Override
	public void execute() throws VV_ExecuteException {
		for(int i =0; i < number; i++){
			commandListNode.execute();
		}
	}
	
	@Override
	public String toString() {
		return "[repeat " + number + " " + commandListNode + "]";
	}

}
