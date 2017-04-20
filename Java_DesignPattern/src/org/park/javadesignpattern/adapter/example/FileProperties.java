package org.park.javadesignpattern.adapter.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class FileProperties extends Properties implements FileIO {
	String filePath = "C:\\JavaDesignPattern\\JavaDesignPattern\\store\\";

	@Override
	public void readFromFile(String filename) throws IOException {
		
		String key=null;
		String value=null;
		int position;
		BufferedReader br = null;
		try{
			br = new BufferedReader(new FileReader(filePath+filename));
			String line;
			while((line = br.readLine()) != null){
				position = line.indexOf("=");
				key = line.substring(0, position);
				value = line.substring(position +1);
				setValue(key, value);
			}
		} catch(FileNotFoundException e){
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		}finally{
			if(br != null) try{br.close();} catch(IOException e) {}
		}

	}

	@Override
	public void writeToFile(String filename) throws IOException {
		String textData = null;
		FileOutputStream output = new FileOutputStream(filePath + filename);
		output.write("#written by FileProperties\r\n".getBytes());
		long time = System.currentTimeMillis();
		SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		String str = dayTime.format(time) + "\r\n";
		output.write(str.getBytes());
		for(String key: hashMap.keySet()){
			textData = key + "=" + hashMap.get(key) + "\r\n";
			output.write(textData.getBytes());
		}
		output.close();

	}

	@Override
	public void setValue(String key, String value) {
		hashMap.put(key, value);

	}

	@Override
	public String getValue(String key) {
		String value = hashMap.get(key);
		if(value.isEmpty() || value.trim().equals("")){
			return null;
		}else{
			return value;
		}
		
	}

}
