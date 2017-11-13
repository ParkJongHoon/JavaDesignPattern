package org.park.javadesignpattern.vday.Interpreter;

// <command> ::= <repeat command> | <primitive command>
public class CommandNode extends V_Node {
	private V_Node node;
	@Override
	public void parse(V_Context context) throws ParseException {
		if(context.currentToken().equals("repeat")){
			node = new RepeatCommandNode();
			node.parse(context);
		}else{
			node = new PrimitiveCommandNode();
			node.parse(context);
		}
	}
	public String toString(){
		return node.toString();
	}
	

}
