package org.park.javadesignpattern.vday.Interpreter.main;

import java.io.BufferedReader;
import java.io.FileReader;

import org.park.javadesignpattern.vday.Interpreter.ProgramNode;
import org.park.javadesignpattern.vday.Interpreter.V_Context;
import org.park.javadesignpattern.vday.Interpreter.V_Node;

public class V_Main {

	public static void main(String[] args) {
		try{
			BufferedReader reader =
					new BufferedReader(new FileReader("program.txt"));
			String text;
			
			while((text = reader.readLine()) != null){
				System.out.println("text =  \"" + text + "\"");
				V_Node node = new ProgramNode();
				node.parse(new V_Context(text));
				System.out.println("node = " +node);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
