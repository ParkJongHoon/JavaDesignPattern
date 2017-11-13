package org.park.javadesignpattern.vday.Interpreter;

import java.util.StringTokenizer;

public class V_Context {
	private StringTokenizer tokenizer;
	private String currentToken;
	public V_Context(String text) {
		tokenizer = new StringTokenizer(text);
		nextToken();
	}
	public void nextToken(){
		if(tokenizer.hasMoreTokens()){
			currentToken = tokenizer.nextToken();
		}else{
			currentToken = null;
		}
	}
	
	public String currentToken(){
		return currentToken;
	}
	
	public void skipToken(String token) throws ParseException{
		if(!token.equals(currentToken)){
			throw new ParseException("Warning: " + token + "is expected, "
					+ "but " + currentToken + " is found.");
		}
		nextToken();
	}

	public int currentNumber() throws ParseException{
		int number = 0;
		try{
			number = Integer.parseInt(currentToken);
		}catch(NumberFormatException e){
			throw new ParseException("Warning: " + e);
		}
		return number;
	}
}
