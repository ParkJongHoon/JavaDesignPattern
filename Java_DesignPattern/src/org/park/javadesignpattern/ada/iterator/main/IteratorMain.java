package org.park.javadesignpattern.ada.iterator.main;

import org.park.javadesignpattern.ada.iterator.Aggregate;
import org.park.javadesignpattern.ada.iterator.Book;
import org.park.javadesignpattern.ada.iterator.Iterator;
import org.park.javadesignpattern.ada.iterator.example.BookShelfArrayList;

public class IteratorMain {
	/**
	 * 작성일: 2017-04-07
	 * 작성자: 박종훈
	 * 작성내용: Iterator Pattern 예제 코드
	 * 
	 * 습득한 내용
	 * 1) 역할의 분리
	 * 2) Iterator의 규격 메소드 - hasNext(), next()
	 * 
	 * 
	 * 역할:
	 * 정의클래스 - Aggregate(집합체), Iterator(반복자)
	 * 구현클래스 - Bookshelf(Aggregate 구현체), BookShelfIterator(Iterator 구현체)
	 * 모델클래스 - Book
	 * 실행클래스 - IteratorMain
	 * 
	 * 반복자 -> 요소를 순서대로 검색해가는 인터페이스를 결정
	 * 집합체 -> Iterator 역할을 만들어내는 인터페이스를 결정
	 * @param args
	 */
	
	public static void main(String[] args) {
		//Aggregate aggregate = new BookShelf(4);
		// 다형성을 이용한 객체 변경
		Aggregate aggregate = new BookShelfArrayList(4);
		aggregate.appendBook(new Book("Around the World in 80 Days"));
		aggregate.appendBook(new Book("Bible"));
		aggregate.appendBook(new Book("Cinderella"));
		aggregate.appendBook(new Book("Daddy-Long-Legs"));
		aggregate.appendBook(new Book("Thinking in java"));
		Iterator it = aggregate.iterator();
		while(it.hasNext()){
			Book book = (Book)it.netxt();
			System.out.println(book.getName());
		}
	}

}
