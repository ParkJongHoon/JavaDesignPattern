package org.park.javadesignpattern.vday.Interpreter;


public abstract class V_Node {
	public abstract void parse(V_Context context) throws ParseException;
}
