package org.park.javadesignpattern.lday.visitor.main;

import java.util.Iterator;

import org.park.javadesignpattern.lday.visitor.FileTreatmentException;
import org.park.javadesignpattern.lday.visitor.Listvisitor;
import org.park.javadesignpattern.lday.visitor.V_Directory;
import org.park.javadesignpattern.lday.visitor.V_File;
import org.park.javadesignpattern.lday.visitor.example.FileFindVisitor;

import tools.dynamiccreate.DynamicObjectCreater;

public class L_Example_Main {
	public static void main(String[] args) {
		try{
			System.out.println("Making root entries...");
			V_Directory rootdir = (V_Directory)DynamicObjectCreater.newInstanceObject("V_Directory", "root");
			V_Directory bindir = (V_Directory)DynamicObjectCreater.newInstanceObject("V_Directory", "bin");
			V_Directory tmpdir = (V_Directory)DynamicObjectCreater.newInstanceObject("V_Directory", "tmp");
			V_Directory usrdir = (V_Directory)DynamicObjectCreater.newInstanceObject("V_Directory", "usr");
			
			rootdir.add(bindir);
			rootdir.add(tmpdir);
			rootdir.add(usrdir);
			bindir.add((V_File)DynamicObjectCreater.newInstanceObject("V_File", "vi", 10000));
			bindir.add((V_File)DynamicObjectCreater.newInstanceObject("V_File", "latex", 20000));
			
			
			V_Directory Kim = (V_Directory)DynamicObjectCreater.newInstanceObject("V_Directory", "kim");
			V_Directory Lee = (V_Directory)DynamicObjectCreater.newInstanceObject("V_Directory", "Lee");
			V_Directory Park = (V_Directory)DynamicObjectCreater.newInstanceObject("V_Directory", "Park");
			usrdir.add(Kim);
			usrdir.add(Lee);
			usrdir.add(Park);
			Kim.add((V_File)DynamicObjectCreater.newInstanceObject("V_File", "diary.html", 100));
			Kim.add((V_File)DynamicObjectCreater.newInstanceObject("V_File", "Composite.java", 200));
			Lee.add((V_File)DynamicObjectCreater.newInstanceObject("V_File", "memo.tex", 300));
			Lee.add((V_File)DynamicObjectCreater.newInstanceObject("V_File", "index.html", 350));
			Park.add((V_File)DynamicObjectCreater.newInstanceObject("V_File", "game.doc", 400));
			Park.add((V_File)DynamicObjectCreater.newInstanceObject("V_File", "junk.mail", 500));
			
			FileFindVisitor ffv = (FileFindVisitor)DynamicObjectCreater.newInstanceObject("FileFindVisitor", ".html");
			rootdir.accept(ffv);
			System.out.println("HTML files are:");
			Iterator it = ffv.getFoundFiles();
			while(it.hasNext()){
				V_File file = (V_File)it.next();
				System.out.println(file.toString());
			}
		}catch(FileTreatmentException e){
			e.printStackTrace();
		}
	}

}
