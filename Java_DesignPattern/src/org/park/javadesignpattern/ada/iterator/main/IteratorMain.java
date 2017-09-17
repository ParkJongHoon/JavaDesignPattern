package org.park.javadesignpattern.ada.iterator.main;

import org.park.javadesignpattern.ada.iterator.Aggregate;
import org.park.javadesignpattern.ada.iterator.Book;
import org.park.javadesignpattern.ada.iterator.Iterator;
import org.park.javadesignpattern.ada.iterator.example.BookShelfArrayList;

public class IteratorMain {
	/**
	 * �ۼ���: 2017-04-07
	 * �ۼ���: ������
	 * �ۼ�����: Iterator Pattern ���� �ڵ�
	 * 
	 * ������ ����
	 * 1) ������ �и�
	 * 2) Iterator�� �԰� �޼ҵ� - hasNext(), next()
	 * 
	 * 
	 * ����:
	 * ����Ŭ���� - Aggregate(����ü), Iterator(�ݺ���)
	 * ����Ŭ���� - Bookshelf(Aggregate ����ü), BookShelfIterator(Iterator ����ü)
	 * ��Ŭ���� - Book
	 * ����Ŭ���� - IteratorMain
	 * 
	 * �ݺ��� -> ��Ҹ� ������� �˻��ذ��� �������̽��� ����
	 * ����ü -> Iterator ������ ������ �������̽��� ����
	 * @param args
	 */
	
	public static void main(String[] args) {
		//Aggregate aggregate = new BookShelf(4);
		// �������� �̿��� ��ü ����
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
