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
			 * program.txt ����
			 * 
			 * program end
			 * program go end
			 * program go right go right go right go right end
			 * program repeat 4 go right end end
			 * program repeat 4 repeat 3  go right go left end right end end
			 */
			
			String text;
			
			// �� �ٸ��� ��� ��� ���
			while((text = reader.readLine()) != null){
				System.out.println("text =  \"" + text + "\"");
				
				// ProgramNode�� V_Node�� ��ӹ��� ����ü
				// public void parse(V_Context context) throws ParseException �ش� �޼ҵ尡 ������
				V_Node node = new ProgramNode();
				// �����ڴ� ����
				
				// ProgramNode -> CommandListNode -> CommandNode -> RepeatCommandNode(repeat �϶���)
				//											   ��-> PrimitiveCommandNode
				node.parse(new V_Context(text));
				System.out.println("node = " +node);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
