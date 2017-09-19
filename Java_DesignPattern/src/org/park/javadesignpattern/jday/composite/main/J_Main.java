package org.park.javadesignpattern.jday.composite.main;

import org.park.javadesignpattern.jday.composite.Directory;
import org.park.javadesignpattern.jday.composite.File;
import org.park.javadesignpattern.jday.composite.FileTreatmentException;

import tools.dynamiccreate.DynamicObjectCreater;

public class J_Main {

	public static void main(String[] args) {
		try{
			System.out.println("Making root entries...");
			Directory rootdir = (Directory)DynamicObjectCreater.newInstanceObject("Directory", "root");
			Directory bindir = (Directory)DynamicObjectCreater.newInstanceObject("Directory", "bin");
			Directory tmpdir = (Directory)DynamicObjectCreater.newInstanceObject("Directory", "tmp");
			Directory usrdir = (Directory)DynamicObjectCreater.newInstanceObject("Directory", "usr");
			rootdir.add(bindir);
			rootdir.add(tmpdir);
			rootdir.add(usrdir);
			bindir.add((File)DynamicObjectCreater.newInstanceObject("File", "vi", 10000));
			bindir.add((File)DynamicObjectCreater.newInstanceObject("File", "latex", 20000));
			rootdir.printList();
			
			System.out.println();
			System.out.println("Making user entries...");
			Directory kim = (Directory)DynamicObjectCreater.newInstanceObject("Directory", "Kim");
			Directory lee = (Directory)DynamicObjectCreater.newInstanceObject("Directory", "Lee");
			Directory park = (Directory)DynamicObjectCreater.newInstanceObject("Directory", "Park");
			usrdir.add(kim);
			usrdir.add(lee);
			usrdir.add(park);
			kim.add((File)DynamicObjectCreater.newInstanceObject("File", "diary.html", 100));
			kim.add((File)DynamicObjectCreater.newInstanceObject("File", "Composite.java", 200));
			lee.add((File)DynamicObjectCreater.newInstanceObject("File", "memo.tex", 300));
			park.add((File)DynamicObjectCreater.newInstanceObject("File", "game.doc", 400));
			park.add((File)DynamicObjectCreater.newInstanceObject("File", "junk.mail", 500));
			rootdir.printList();
		}catch(FileTreatmentException e){
			
		}

	}

}
