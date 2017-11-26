package org.park.javadesignpattern.vvday.Interpreter.example;

import java.util.StringTokenizer;


public class VV_Context implements VV_ExecutorFactory {
	private VV_ExecutorFactory factory;
	private StringTokenizer tokenizer;
	private String currentToken;
	public VV_Context(String text) {
		tokenizer = new StringTokenizer(text);
		
	}
	public String nextToken(){
		if(tokenizer.hasMoreTokens()){
			currentToken = tokenizer.nextToken();
		}else{
			currentToken = null;
		}
		return currentToken;
	}
	public String currentToken(){
		return currentToken;
	}
	public void skipToken(String token) throws VV_ParseException{
		if(!token.equals(currentToken)){
			throw new VV_ParseException("Warning: " + token + " is expected,"
					+ "but " + currentToken + " is found");
		}
		nextToken();
	}
	public int currentNumber() throws VV_ParseException{
		int number = 0;
		try{
			number = Integer.parseInt(currentToken);
		}catch(NumberFormatException e){
			throw new VV_ParseException("Warning: " + e);
		}
		return number;
	}
	
	
	public void setExecutorFactory(VV_ExecutorFactory factory) {
		this.factory = factory;
	}
	@Override
	public VV_Executor createExecutor(String name) {
		return factory.createExecutor(name);
	}

}
