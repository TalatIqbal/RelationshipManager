package ca.allyengine.relmanager.io.parser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ca.allyengine.relmanager.config.Config;
import io.file.reader.IReader;
import io.file.reader.LocalFileSystemReader;

public class CSVParser implements IParser {

	@Override
	public Map<String, List<String>> Parse(String filePath) {

        InputStreamReader reader;
        Map<String, List<String>> data = null;
        try {
        	IReader fileReader = new LocalFileSystemReader();
            InputStream newInputStream = fileReader.read(filePath);
            reader = new InputStreamReader(newInputStream);

            BufferedReader br = new BufferedReader(reader,9999999);
            String line;
            
            Map<Integer, String> titles = new HashMap<>();
            data = new HashMap<>();      
            
            line = br.readLine();
            String [] dataValues = line.split(Config.DELIMITER_CSV);
            
            for(int i=0; i<dataValues.length;i++) {
            	String title = dataValues[i];
            	titles.put(i, title);
            	data.put(title, new ArrayList<>());
            }
            
            while (line != null) {                                
            	dataValues = line.split(Config.DELIMITER_CSV);   
            	if(dataValues.length != titles.size()) {
            		throw new Exception("Data is not correct");
            	}
            	for(int i=0; i<dataValues.length;i++) {
            		data.get(titles.get(i)).add(dataValues[i]);
                }
                line = br.readLine();
            }
            reader.close();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception ex) {
        	System.out.println("EXCEPTION IN CSVParser.parse(): "+ex.getMessage());
        	ex.printStackTrace();
        }
        
        return data;
	}

}
