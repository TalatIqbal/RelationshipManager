package ca.allyengine.analyzer.datatype;

public class Integer {

	/**
	 * Returns a integer value if the parameter sent is a valid integer
	 * @param value
	 * @return java.lang.Integer if the value is a Integer, else null
	 */
	public static java.lang.Integer tryParse(String value) {
		java.lang.Integer convertedValue = null;		
		try {
			convertedValue = java.lang.Integer.parseInt(value);
			return convertedValue;			
		} catch (Exception ex) {
			return null;
		} 
	}
}
