package org.park.javadesignpattern.adapter.example;

import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;


public class Properties {
	
	HashMap<String, String> hashMap;
	public Properties() {
		hashMap = new HashMap<String, String>();
	}
	
	public void outputCreateFile(String filename, HashMap<String, String> value){
		try{
			File file = new File(filename);
			FileWriter fw = new FileWriter(file, true);
			
		}catch(Exception e){
			
		}
	}

}
