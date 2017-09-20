package ca.allyengine.database.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	public static Connection connect(Connection connection,String databaseName) {		
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			connection = DriverManager.getConnection(
					Authentication.getConnectionString(databaseName),
					Authentication.getUser(),
					Authentication.getPassword());
			return connection;			  
		}catch(Exception ex){ 
			System.out.println("EXCEPTION in DatabaseConnection.connect()");
			ex.printStackTrace();
			return null;
		} 		
	}
	
	public static Connection connect(Connection connection) {		
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			connection = DriverManager.getConnection(
					Authentication.getConnectionString(),
					Authentication.getUser(),
					Authentication.getPassword());
			return connection;			  
		}catch(Exception ex){ 
			System.out.println("EXCEPTION in DatabaseConnection.connect()");
			ex.printStackTrace();
			return null;
		} 		
	}
	
	public static boolean close(Connection connection) {
		try {
            if (connection != null) { 
            	connection.close();
            }
            return true;
        } catch (SQLException sqlExc) {
        	System.out.println("EXCEPTION in DatabaseConnection.close()");
            System.out.println(sqlExc.getMessage());
            return false;
        } 
	}
}
