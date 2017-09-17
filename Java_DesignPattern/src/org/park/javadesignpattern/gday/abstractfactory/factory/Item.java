package org.park.javadesignpattern.gday.abstractfactory.factory;

public abstract class Item {
	protected String caption;
	public Item(String caption){
		this.caption = caption;
	}
	public abstract String makeHTML();
}
