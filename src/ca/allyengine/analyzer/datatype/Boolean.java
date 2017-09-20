package ca.allyengine.analyzer.datatype;

public class Boolean {	
	/**
	 * Returns a boolean value if the parameter sent is a valid boolean
	 * @param value
	 * @return java.lang.Boolean if the value is a boolean, else null
	 */
	public static java.lang.Boolean tryParse(String value) {		
		java.lang.Boolean convertedValue = null;		
		try {
			convertedValue = java.lang.Boolean.parseBoolean(value);
			return convertedValue;			
		} catch (Exception ex) {
			return null;
		} 
	}
}
