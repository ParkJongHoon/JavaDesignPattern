package org.park.javadesignpattern.vvday.Interpreter.example;

// <command> :: <repeat command> | <primitive command>
public class VV_CommandNode extends VV_Node {
	private VV_Node node;

	@Override
	public void parse(VV_Context context) throws VV_ParseException {
		if(context.currentToken().equals("repeat")){
			node = new VV_RepeatCommandNode();
			node.parse(context);
		}else{
			node = new VV_PrimitiveCommandNode();
			node.parse(context);
		}

	}
	@Override
	public void execute() throws VV_ExecuteException {
		node.execute();
	}

	@Override
	public String toString() {
		return node.toString();
	}
	
}
