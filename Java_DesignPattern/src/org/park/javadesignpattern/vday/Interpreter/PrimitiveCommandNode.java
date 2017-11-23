package org.park.javadesignpattern.vday.Interpreter;

// <primitive command> ::= go | right | left
public class PrimitiveCommandNode extends V_Node {
	private String name;
	@Override
	public void parse(V_Context context) throws ParseException {
		name = context.currentToken();
		// name: go
		context.skipToken(name); // <- skipToken일때 Token이 다음 단어로 교체됨
		if(!name.equals("go") && !name.equals("right") &&
				!name.equals("left")){
			throw new ParseException(name + " is undefined");
			
		}
	}
	public String toString(){
		return name;
	}

}
