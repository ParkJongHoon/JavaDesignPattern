package org.park.javadesignpattern.factorymethod.idcard;

import java.util.*;

import org.park.javadesignpattern.factorymethod.framework.Factory;
import org.park.javadesignpattern.factorymethod.framework.Product;

public class IDCardFactory extends Factory {
	private HashMap database = new HashMap();
	private int serial = 100;
	@Override
	protected synchronized Product createProduct(String owner) {
		return new IDCard(owner, serial++);
	}

	@Override
	protected void registerProduct(Product product) {
		IDCard card = (IDCard)product;
		database.put(new Integer(card.getSerial()), card.getOwner());
		
	}
	
	public HashMap getDatabase(){
		return database;
	}

}
