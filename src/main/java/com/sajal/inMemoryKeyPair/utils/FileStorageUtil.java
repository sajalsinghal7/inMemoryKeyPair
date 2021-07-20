package com.sajal.inMemoryKeyPair.utils;

import java.io.FileWriter;
import java.io.IOException;

public class FileStorageUtil extends ExpiredCacheFactory {
	@Override
	public void append(String data) {
		// TODO Auto-generated method stub
		try
		{
		    String filename= "expiredData.txt";
		    FileWriter fw = new FileWriter(filename,true); //the true will append the new data
		    fw.write(data + "\n");//appends the string to the file
		    fw.close();
		}
		catch(IOException ioe)
		{
		    System.err.println("IOException: " + ioe.getMessage());
		}
	}
}
