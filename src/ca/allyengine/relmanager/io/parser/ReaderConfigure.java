package ca.allyengine.relmanager.io.parser;

import ca.allyengine.relmanager.config.Config;

public class ReaderConfigure {
	public static IParser Configure(String filePath) {
		String extension = getExtension(filePath, ".");
		IParser reader = null;
		switch (extension) {
			case Config.EXTENSION_CSV:
				reader = new CSVParser();
				break;
			default :
				break;
		}		
		return reader;
	}
	
	private static String getExtension(String filePath, String delimiterChar) {
		String extension = "";
		if(filePath != null && !filePath.isEmpty()) {
			extension = filePath.substring(filePath.lastIndexOf(delimiterChar), filePath.length());
		}
		return extension;
	}
}
