package org.park.javadesignpattern.lday.visitor;

import java.util.Iterator;

public class Listvisitor extends Visitor {
	private String currentdir = "";
	@Override
	public void visit(V_File file) {
		System.out.println(currentdir + "/" + file);
	}

	@Override
	public void visit(V_Directory directory) {
		System.out.println(currentdir + "/" + directory);
		String savedir = currentdir;
		currentdir = currentdir + "/" + directory.getName();
		Iterator it = directory.iterator();
		while(it.hasNext()){
			V_Entry entry = (V_Entry)it.next();
			entry.accept(this);
		}
		//System.out.println();
		currentdir = savedir;
		//System.out.println("currentdir: " + currentdir);

	}

}
