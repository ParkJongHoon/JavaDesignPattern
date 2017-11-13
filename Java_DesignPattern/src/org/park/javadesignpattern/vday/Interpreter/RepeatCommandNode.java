package org.park.javadesignpattern.vday.Interpreter;

// <repeat command> ::= repeat <number> <command list>
public class RepeatCommandNode extends V_Node {
	private int number;
	private V_Node commandListNode;
	@Override
	public void parse(V_Context context) throws ParseException {
		context.skipToken("repeat");
		number = context.currentNumber();
		context.nextToken();
		commandListNode = new CommandListNode();
		commandListNode.parse(context);
	}
	public String toString(){
		return "{repeat " + number + " " + commandListNode + "]";
	}

}
