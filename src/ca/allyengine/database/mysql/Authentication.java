package ca.allyengine.database.mysql;

public class Authentication {
	
	private static String USER = "root"; 
	private static String PASSWORD = "AmiiMeerkat";
	private static String CONNECTIONSTRING = "jdbc:mysql://localhost:3306/";
	
	public static String getUser() {
		return USER;
	}
	
	public static String getPassword() {
		return PASSWORD;
	}
	
	public static String getConnectionString(String databaseName) {
		return CONNECTIONSTRING+databaseName;
	}
	
	public static String getConnectionString() {
		return CONNECTIONSTRING+"mysql?zeroDateTimeBehavior=convertToNull";
	}
}

