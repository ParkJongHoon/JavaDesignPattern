package org.park.javadesignpattern.adapter.example;

import java.io.IOException;

public class FileProperties extends Properties implements FileIO {
	

	@Override
	public void readFromFile(String filename) throws IOException {
		properReadFromFile(filename);
	}

	@Override
	public void writeToFile(String filename) throws IOException {
		properWriteToFile(filename);
	}

	@Override
	public void setValue(String key, String value) {
		properSetValue(key, value);

	}
	@Override
	public String getValue(String key) {
		return properGetValue(key);
	}

}
