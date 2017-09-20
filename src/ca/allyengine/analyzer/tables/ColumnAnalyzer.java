package ca.allyengine.analyzer.tables;

import java.util.List;

import ca.allyengine.analyzer.datatype.Analyzer;
import ca.allyengine.analyzer.datatype.Type.DataType;

public class ColumnAnalyzer {

	public static DataType getColumnDataType(List<String> dataValues) {		
		return Analyzer.getDataType(dataValues);
	}
}
