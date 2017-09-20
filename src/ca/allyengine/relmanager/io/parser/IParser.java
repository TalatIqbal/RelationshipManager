package ca.allyengine.relmanager.io.parser;

import java.util.List;
import java.util.Map;

public interface IParser {
	
	public Map<String, List<String>> Parse(String filePath);

}
