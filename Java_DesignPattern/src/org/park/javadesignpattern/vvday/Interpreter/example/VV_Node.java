package org.park.javadesignpattern.vvday.Interpreter.example;

public abstract class VV_Node implements VV_Executor {
	public abstract void parse(VV_Context context) throws VV_ParseException;
}
