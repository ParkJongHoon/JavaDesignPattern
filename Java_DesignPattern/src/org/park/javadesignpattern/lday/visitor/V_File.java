package org.park.javadesignpattern.lday.visitor;

public class V_File extends V_Entry {
	private String name;
	private int size;
	public V_File(String name, int size) {
		this.name = name;
		this.size = size;
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getSize() {
		return size;
	}

}
