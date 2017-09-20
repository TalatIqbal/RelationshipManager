package io.file.reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class LocalFileSystemReader implements IReader {

	InputStream dataObjectStream ;
	
	public LocalFileSystemReader() {
		
	}
	
	@Override
	public InputStream read(String filePath) {
		try {
			dataObjectStream = new FileInputStream(new File(filePath));
		} catch (FileNotFoundException e) {
			System.out.println("EXCEPTION in LocalFileSystem.read()");
			e.printStackTrace();
		}
		return dataObjectStream;
	}

}
