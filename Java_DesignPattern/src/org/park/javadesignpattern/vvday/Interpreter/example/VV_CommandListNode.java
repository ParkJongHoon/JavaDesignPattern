package org.park.javadesignpattern.vvday.Interpreter.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VV_CommandListNode extends VV_Node {
	private List<VV_Node> list = new ArrayList<VV_Node>();
	@Override
	public void parse(VV_Context context) throws VV_ParseException {
		while(true){
			if(context.currentToken() == null){
				throw new VV_ParseException("Missing end");
			}else if(context.currentToken().equals("end")){
				context.skipToken("end");
			}else{
				VV_Node commandNode = new VV_CommandNode();
				commandNode.parse(context);
				list.add(commandNode);
			}
			
		}

	}
	@Override
	public void execute() throws VV_ExecuteException {
		Iterator<VV_Node> it = list.iterator();
		while(it.hasNext()){
			((VV_CommandNode)it.next()).execute();
		}
	}
	
	@Override
	public String toString() {
		return list.toString();
	}

	

}
