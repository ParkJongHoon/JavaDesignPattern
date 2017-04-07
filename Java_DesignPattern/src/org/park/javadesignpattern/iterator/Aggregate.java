package org.park.javadesignpattern.iterator;

public interface Aggregate {
	public abstract Iterator iterator();
	public Book getBookAt(int index);
	public void appendBook(Book book);
	public int getLength();
}
