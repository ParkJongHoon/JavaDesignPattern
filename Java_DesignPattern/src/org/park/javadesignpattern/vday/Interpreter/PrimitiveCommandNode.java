package org.park.javadesignpattern.vday.Interpreter;

// <primitive command> ::= go | right | left
public class PrimitiveCommandNode extends V_Node {
	private String name;
	@Override
	public void parse(V_Context context) throws ParseException {
		name = context.currentToken();
		// name: go
		context.skipToken(name); // <- skipToken�϶� Token�� ���� �ܾ�� ��ü��
		if(!name.equals("go") && !name.equals("right") &&
				!name.equals("left")){
			throw new ParseException(name + " is undefined");
			
		}
	}
	public String toString(){
		return name;
	}

}
