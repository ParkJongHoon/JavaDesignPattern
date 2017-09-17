package org.park.javadesignpattern.bday.templatemethod;

public abstract class AbstractDisplay {
	public abstract void open();
	public abstract void print();
	public abstract void close();
	
	// template method pattern¿« Ω««‡∞Ë»π
	public final void display(){
	
		open();
		for(int i =0; i< 5; i++){
			print();
		}
		close();
	}
}
