package org.park.javadesignpattern.adapter.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileProperties extends Properties implements FileIO {

	@Override
	public void readFromFile(String filename) throws IOException {
		BufferedReader br = null;
		try{
			br = new BufferedReader(new FileReader(filename));
			String line;
			while((line = br.readLine()) != null){
				String key;
				String value;
				int position;
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
		// TODO Auto-generated method stub

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
