package org.park.javadesignpattern.lday.visitor;

import java.util.Iterator;

public class SizeVisitor extends Visitor {
	private int size = 0;
	public int getSize(){
		return size;
	}
	
	@Override
	public void visit(V_File file) {
		size += file.getSize();
	}

	@Override
	public void visit(V_Directory directory) {
		Iterator it = directory.iterator();
		while(it.hasNext()){
			V_Entry entry = (V_Entry)it.next();
			entry.accept(this);
		}
	}

}
