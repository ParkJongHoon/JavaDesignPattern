package org.park.javadesignpattern.vday.Interpreter.main;

import java.io.BufferedReader;
import java.io.FileReader;

import org.park.javadesignpattern.vday.Interpreter.ParseException;
import org.park.javadesignpattern.vday.Interpreter.ProgramNode;
import org.park.javadesignpattern.vday.Interpreter.V_Context;
import org.park.javadesignpattern.vday.Interpreter.V_Node;

public class V_Main {

	public static void main(String[] args) {
		try{
			BufferedReader reader =
					new BufferedReader(new FileReader("program.txt"));
			/**
			 * program.txt 내용
			 * 
			 * program end
			 * program go end
			 * program go right go right go right go right end
			 * program repeat 4 go right end end
			 * program repeat 4 repeat 3  go right go left end right end end
			 */
			
			String text;
			
			// 각 줄마다 노드 찍는 기능
			while((text = reader.readLine()) != null){
				System.out.println("text =  \"" + text + "\"");
				
				// ProgramNode는 V_Node를 상속받은 구현체
				// public void parse(V_Context context) throws ParseException 해당 메소드가 존재함
				V_Node node = new ProgramNode();
				// 생성자는 없음
				
				// ProgramNode -> CommandListNode -> CommandNode -> RepeatCommandNode(repeat 일때만)
				//											   ㄴ-> PrimitiveCommandNode
				node.parse(new V_Context(text));
				System.out.println("node = " +node);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
