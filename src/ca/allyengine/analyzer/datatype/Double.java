package ca.allyengine.analyzer.datatype;

public class Double {	
	/**
	 * Returns a double value if the parameter sent is a valid double
	 * @param value
	 * @return java.lang.Double if the value is a double, else null
	 */
	public static java.lang.Double tryParse(String value) {		
		java.lang.Double convertedValue = null;		
		try {
			convertedValue = java.lang.Double.parseDouble(value);
			return convertedValue;			
		} catch (Exception ex) {
			return null;
		} 
	}

}
