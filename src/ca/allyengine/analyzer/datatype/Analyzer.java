package ca.allyengine.analyzer.datatype;

import java.util.List;

import ca.allyengine.analyzer.datatype.Type.DataType;

public class Analyzer {
	
	public static DataType getDataType(String dataValue) {
	
		DataType result= DataType.STRING ;
		if(Double.tryParse(dataValue) != null) {
			result = DataType.DECIMAL;
		}
		
		if(Integer.tryParse(dataValue) != null) {
			result = DataType.INTEGER;
		}
		
		if(Boolean.tryParse(dataValue) != null) {
			result = DataType.BOOLEAN;
		}
		
		return result;
	}
	
	public static int getBitwiseAndMultiplier(DataType type) {		
		switch (type) {
			case STRING:
				return 1;
			case DECIMAL:
				return 3;
			case INTEGER:
				return 7;
			case BOOLEAN:
				return 9;
			case DATETIME:
				return 17;
			default:
				return 1;
		}
	}
	
	public static DataType getDataTypeFromIntRepresentation(int integerValue) {		
		switch (integerValue) {
			case 1:
				return DataType.STRING;
			case 3:
				return DataType.DECIMAL;
			case 7:
				return DataType.INTEGER;
			case 9:
				return DataType.BOOLEAN;
			case 17:
				return DataType.DATETIME;
			default:
				return DataType.STRING;
		}
	}
	
	public static DataType getDataType(List<String> dataValues) {
		DataType result= DataType.STRING ;
		int resultOperator = (int)Math.pow(2.0, DataType.values().length) - 1; // 2^numItemsInEnum - 1
		try {
			for(String dataValue : dataValues) {
				dataValue = dataValue.trim();
				if(!dataValue.isEmpty()) {
					DataType typeCurrent = getDataType(dataValue);
					resultOperator = resultOperator  & getBitwiseAndMultiplier(typeCurrent);
				}
			}			
			result = getDataTypeFromIntRepresentation(resultOperator);
		} catch (Exception ex) {
			System.out.println("EXCEPTION in Analyzer.getDataType()");
			ex.printStackTrace();			
		}
		return result;
	}

}
