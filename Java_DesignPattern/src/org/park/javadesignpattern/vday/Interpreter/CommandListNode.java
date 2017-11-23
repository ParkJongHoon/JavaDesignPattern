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
		//program go right go right go right go right end��� �ִ� V_Context -> context 
		// currentToken�� go
		while(true){
			if(context.currentToken() == null){
				throw new ParseException("Missing 'end' " );
			}else if(context.currentToken().equals("end")){
				context.skipToken("end"); // <- skipToken�϶� Token�� ���� �ܾ�� ��ü��
				break;
			 }else{
				V_Node commandNode = new CommandNode();
				commandNode.parse(context);
				list.add(commandNode);
				
				// list�� CommandNode()���� PrimitiveCommandNode() -> name�� ����
				//							RepeatcommandNode() -> "{repeat ���� [�ݺ���]  }"
				// 							RepeatCommandNode()���� end ������ �ش� �迭 ���� '}' <- �� ǥ��
			}
		}
	}

	public String toString(){
		return list.toString();
	}
}
