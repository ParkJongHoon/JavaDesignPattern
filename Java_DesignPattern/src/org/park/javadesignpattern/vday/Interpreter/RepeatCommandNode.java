package org.park.javadesignpattern.vday.Interpreter;

// <repeat command> ::= repeat <number> <command list>
public class RepeatCommandNode extends V_Node {
	private int number;
	private V_Node commandListNode;
	@Override
	public void parse(V_Context context) throws ParseException {
		context.skipToken("repeat");
		number = context.currentNumber();
		context.nextToken(); // <- skipToken일때 Token이 다음 단어로 교체됨
		// currentToken이 유지된 상태에서 CommandListNode()를 생성함
		commandListNode = new CommandListNode();
		commandListNode.parse(context);
	}
	public String toString(){
		return "{repeat " + number + " " + commandListNode + "}";
	}

}
