package org.park.javadesignpattern.iterator_and_template;

import java.util.ArrayList;
import java.util.Iterator;

import org.park.javadesignpattern.templatemethod.AbstractDisplay;
import org.park.javadesignpattern.templatemethod.CharDisplay;
import org.park.javadesignpattern.templatemethod.StringDisplay;

public class AbstractIteratorImpi extends ArrayList<AbstractDisplay> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AbstractIteratorImpi() {
		
	}
	
	private AbstractDisplay typeCheckReturnAbstractDisplay(Object object){
		if(object instanceof Character){
			return new CharDisplay(((Character) object).charValue());
		}else if(object instanceof String){
			return new StringDisplay(object.toString());
		}else{
			return null;
		}
	}
	
	public void enrollAbstractDisplay(Object object){
		AbstractDisplay ad = typeCheckReturnAbstractDisplay(object);
		this.add(ad);
	}
	
	public void iteratorAbstractDisplay(){
		Iterator<AbstractDisplay> iterator = this.iterator();
		while(iterator.hasNext()){
			AbstractDisplay ad = iterator.next();
			ad.display();
			System.out.println();
		}
	}
}
