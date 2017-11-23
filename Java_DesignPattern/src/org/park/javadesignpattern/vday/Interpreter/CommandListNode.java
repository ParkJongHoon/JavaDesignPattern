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
		//program go right go right go right go right end담고 있는 V_Context -> context 
		// currentToken이 go
		while(true){
			if(context.currentToken() == null){
				throw new ParseException("Missing 'end' " );
			}else if(context.currentToken().equals("end")){
				context.skipToken("end"); // <- skipToken일때 Token이 다음 단어로 교체됨
				break;
			 }else{
				V_Node commandNode = new CommandNode();
				commandNode.parse(context);
				list.add(commandNode);
				
				// list는 CommandNode()안의 PrimitiveCommandNode() -> name을 찍음
				//							RepeatcommandNode() -> "{repeat 숫자 [반복문]  }"
				// 							RepeatCommandNode()에서 end 만나면 해당 배열 종료 '}' <- 이 표시
			}
		}
	}

	public String toString(){
		return list.toString();
	}
}
