package org.park.javadesignpattern.ada.iterator;

public class BookShelfIterator implements Iterator {
	private Aggregate aggregate;
	private int index;
	public BookShelfIterator(Aggregate aggregate) {
		this.aggregate = aggregate;
		this.index = 0;
	}

	@Override
	public boolean hasNext() {
		if(index < aggregate.getLength()){
			return true;
		}else{
			return false;	
		}
	}

	@Override
	public Object netxt() {
		Book book = aggregate.getBookAt(index);
		index++;
		return book;
	}

}
