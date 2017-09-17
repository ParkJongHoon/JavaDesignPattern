package org.park.javadesignpattern.fday.builder.example;

public interface BuilderInfa {
	public void makeTitle(String title);
	public void makeString(String str);
	public void makeItems(String[] items);
	public String getResult();
	public void close();
}
