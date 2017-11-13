package org.park.javadesignpattern.vday.Interpreter;

import java.util.ArrayList;
import java.util.List;

public class CommandListNode extends V_Node {
	private List<V_Node> list = null;
	
	public CommandListNode() {
		list = new ArrayList<V_Node>();
	}
	@Override
	public void parse(V_Context context) throws ParseException {
		while(true){
			if(context.currentToken() == null){
				throw new ParseException("Missing 'end' " );
			}else if(context.currentToken().equals("end")){
				context.skipToken("end");
				break;
			 }else{
				V_Node commandNode = new CommandNode();
				commandNode.parse(context);
				list.add(commandNode);
			}
		}
	}

	public String toString(){
		return list.toString();
	}
}
