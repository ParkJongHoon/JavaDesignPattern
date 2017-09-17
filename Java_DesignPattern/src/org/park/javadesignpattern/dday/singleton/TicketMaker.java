package org.park.javadesignpattern.dday.singleton;

public class TicketMaker {
	private static TicketMaker ticketMaker = new TicketMaker();
	private TicketMaker(){
		System.out.println("create TicketMaker");
	}
	public static TicketMaker getTicketMaker(){
		return ticketMaker;
	}
	
	private int ticket = 1000;
	public synchronized int getNextTicketNumber(){
		return ticket++;
	}

}
