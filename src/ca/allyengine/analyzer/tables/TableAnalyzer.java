package ca.allyengine.analyzer.tables;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ca.allyengine.analyzer.datatype.Type.DataType;

public class TableAnalyzer {

	public static Map<String, DataType> getColumnDataTypes(Map<String, List<String>> tableValues){
		
		Map<String, DataType> tableColumnTypes = null;
		try {
			tableColumnTypes = new HashMap<>();
			
			for (String columnTitle : tableValues.keySet()) {
				DataType columnType = ColumnAnalyzer.getColumnDataType(tableValues.get(columnTitle));
				tableColumnTypes.put(columnTitle, columnType);
			}
		} catch (Exception ex) {
			System.out.println("EXCEPTION in TableAnalyzer.getColumnDataTypes");
			ex.printStackTrace();
		}
		
		return tableColumnTypes;
	}
}
