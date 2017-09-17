package org.park.javadesignpattern.ada.iterator.example;
import java.util.ArrayList;
import java.util.List;

import org.park.javadesignpattern.ada.iterator.Aggregate;
import org.park.javadesignpattern.ada.iterator.Book;
import org.park.javadesignpattern.ada.iterator.BookShelfIterator;
import org.park.javadesignpattern.ada.iterator.Iterator;

public class BookShelfArrayList implements Aggregate {
	private List<Book> books;
	
	public BookShelfArrayList(int maxsize) {
		books = new ArrayList<Book>();
	}
	public Book getBookAt(int index){
		return books.get(index);
	}
	
	public void appendBook(Book book){
		this.books.add(book);
	}
	
	public int getLength(){
		return books.size();
	}
	
	@Override
	public Iterator iterator() {
		return new BookShelfIterator(this);
	}

}
