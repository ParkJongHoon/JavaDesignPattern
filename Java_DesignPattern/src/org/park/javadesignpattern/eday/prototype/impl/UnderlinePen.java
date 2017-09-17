package org.park.javadesignpattern.eday.prototype.impl;

import org.park.javadesignpattern.eday.prototype.framework.ConCreateProduct;
import org.park.javadesignpattern.eday.prototype.framework.Product;

public class UnderlinePen extends ConCreateProduct {
	private char ulchar;
	public UnderlinePen(char ulchar) {
		this.ulchar = ulchar;
	}

	@Override
	public void use(String s) {
		int length = s.getBytes().length;
		System.out.println("\"" + s + "\"");
		System.out.print(" ");
		for(int i =0; i < length; i ++){
			System.out.print(ulchar);
		}
		System.out.println("");
	}

	@Override
	public Product createClone() {
		Product p = null;
		try{
			p = (Product)clone();
		}catch(CloneNotSupportedException e){
			e.printStackTrace();
		}
		return p;
	}

}
