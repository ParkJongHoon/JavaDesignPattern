package org.park.javadesignpattern.adapter.example.main;

import java.io.IOException;

import org.park.javadesignpattern.adapter.example.FileIO;
import org.park.javadesignpattern.adapter.example.FileProperties;

public class ExampleMain {

	public static void main(String[] args) {
		FileIO f = new FileProperties();
			try{
				f.setValue("year", "2004");
				f.setValue("month", "4");
				f.setValue("day", "21");
				f.writeToFile("newfile.txt");
				
			}catch(IOException e){
				e.printStackTrace();
			}

	}

}
