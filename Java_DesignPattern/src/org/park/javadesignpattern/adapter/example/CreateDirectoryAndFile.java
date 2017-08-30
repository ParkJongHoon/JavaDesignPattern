package org.park.javadesignpattern.adapter.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class CreateDirectoryAndFile {
	private String dirctoryPath= "adapterPattern//";
	private String rootPath;
	private String addDirectory;
	private String filename;
	private File directory;
	private File file;
	
	
	public CreateDirectoryAndFile(){
		makeRootPath();
		dirctoryPath = rootPath + dirctoryPath;
		directory = new File(dirctoryPath);
	}
	
	public void executePlan(){
		makeRootPath();
		dirctoryPath = rootPath + dirctoryPath;
		directory = new File(dirctoryPath);
		rootDrirectoryCreate();
	}
	
	
	public void rootDrirectoryCreate(){
		if(!directory.exists()){
			directory.mkdirs();
			System.out.println("Created directory successfully");
		}else{
			System.out.println("already exist");
		}
	}
	
	public void fileCreate(String filename, boolean isInitDataInput){
		this.filename = dirctoryPath + filename;
		//System.out.println("filename: " + this.filename);
		this.file = new File(this.filename);
		try {
			this.file.createNewFile();
			if(isInitDataInput)
				defaultDataInput(this.file);
			System.out.println("Created File: " + filename);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean isNotFile(String filename){
		String isFilename = dirctoryPath + filename;
		// System.out.println("isFilename: " +isFilename);
		File isFile = new File(isFilename);
		return !isFile.exists();
	} 
	
	public void makeRootPath(){
		String thisClassPath = this.getClass().getResource(".").getPath();
		String rootPath = null;
		StringTokenizer st = new StringTokenizer(thisClassPath, "/");
		
		int count =0;
		
		while(st.hasMoreTokens()){
			if(count ==0){
				rootPath = st.nextToken() + "//";
				count++;
			}
			
			if(count >= 1){
				this.rootPath = rootPath;
				break;
			}
		}
		
	}
	
	public void defaultDataInput(File file){
		FileWriter fileWriter;
		BufferedWriter bufferedWriter;
		try {
			fileWriter = new FileWriter(file);
		    bufferedWriter = new BufferedWriter(fileWriter);
			
			bufferedWriter.write("year=1999");
			bufferedWriter.close();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public String getDirctoryPath() {
		return dirctoryPath;
	}


	public File getDirectory() {
		return directory;
	}
	
	
	
	
}
