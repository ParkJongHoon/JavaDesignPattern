package org.park.javadesignpattern.lday.visitor;

import java.util.ArrayList;
import java.util.Iterator;

import tools.dynamiccreate.DynamicObjectCreater;

public class V_Directory extends V_Entry {
	private String name;
	private ArrayList dir = new ArrayList();
	public V_Directory(String name) {
		this.name = name;
	}
	
	@Override
	public String getName() {
		return name;
	}
	@Override
	public int getSize() {
		SizeVisitor v = (SizeVisitor)DynamicObjectCreater.newInstanceObject("SizeVisitor");
		accept(v);
		return v.getSize();
	}
	public V_Entry add(V_Entry entry){
		dir.add(entry);
		return this;
	}
	public Iterator iterator(){
		return dir.iterator();
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);

	}

	



}
