package ca.allyengine.relmanager.io.parser;

import java.io.File;

public class DirectoryParser {

	public static boolean Parse(String directoryPath) {
		boolean success = false ;
		try {
			File folder = new File(directoryPath);
			File[] listOfFiles = folder.listFiles();
			
			for (int index=0; index<listOfFiles.length; index++) {
				if (listOfFiles[index].isFile()) {
					String filePath = listOfFiles[index].getAbsolutePath();
					IParser reader = ReaderConfigure.Configure(filePath);
					reader.Parse(filePath);
				}
			}
		} catch (Exception ex) {
			System.out.println("EXCEPTION in DirectoryReader.Read()");
			ex.printStackTrace();
		}
		
		return success;
	}
}
