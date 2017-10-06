package org.park.javadesignpattern.lday.visitor.example;

import java.util.ArrayList;
import java.util.Iterator;

import org.park.javadesignpattern.lday.visitor.V_Directory;
import org.park.javadesignpattern.lday.visitor.V_Entry;
import org.park.javadesignpattern.lday.visitor.V_File;
import org.park.javadesignpattern.lday.visitor.Visitor;

public class FileFindVisitor extends Visitor {
	private String filetype;
	private ArrayList found = new ArrayList();
	public FileFindVisitor(String filetype) {	// ".txt"�� ���� Ȯ���ڿ� .�� �ٿ� ����
		this.filetype = filetype;
	}
	public Iterator getFoundFiles(){		// �߰��� ������ ��´�.
		return found.iterator();
	}

	@Override
	public void visit(V_File file) {
		if(file.getName().endsWith(filetype)){
			found.add(file);
		}

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
