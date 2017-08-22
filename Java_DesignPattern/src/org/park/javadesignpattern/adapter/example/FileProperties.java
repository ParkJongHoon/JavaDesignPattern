package org.park.javadesignpattern.adapter.example;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class FileProperties extends Properties implements FileIO {
	CreateDirectoryAndFile createDirectoryAndFile;
	Enumeration<Object> keys;
	
	public FileProperties() {
		createDirectoryAndFile = new CreateDirectoryAndFile();
	}
	
	@Override
	public void readFromFile(String filename) throws IOException {
		
		if(!createDirectoryAndFile.getDirectory().exists()){
			createDirectoryAndFile.rootDrirectoryCreate();
			createDirectoryAndFile.fileCreate(filename, true);
		}else if(createDirectoryAndFile.isNotFile(filename)){
			createDirectoryAndFile.fileCreate(filename, true);
		}else{
			System.out.println("read " + filename);
		}
		this.load(new FileInputStream(createDirectoryAndFile.getDirctoryPath()+filename));
		keys = this.keys();
		
	}

	@Override
	public void writeToFile(String filename) throws IOException {
		//properWriteToFile(filename);
		boolean isFile = false;
		String fileState = "";
		isFile = !createDirectoryAndFile.isNotFile(filename);
		FileOutputStream out = new FileOutputStream(createDirectoryAndFile.getDirctoryPath() + filename);
		this.store(out, "properties test");
		out.close();
		if(isFile){
			fileState = "Edit ";
		}else{
			fileState = "Create ";
		}
		System.out.println(fileState + filename);
	}

	@Override
	public void setValue(String key, String value) {
		//properSetValue(key, value);
		this.setProperty(key, value);

	}
	@Override
	public String getValue(String key) {
		return this.getProperty(key);
	}
	
	@Override
	public void allPropertiesPrint(){
		try{
			while(keys.hasMoreElements()){
				String key = keys.nextElement().toString();
				System.out.println(key+ " = " + this.getProperty(key));
			}	
		}catch(NullPointerException e){
			System.err.println("properties not regist, nullPointException");
		}
		
		
	}
	
}
