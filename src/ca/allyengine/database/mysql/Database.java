package ca.allyengine.database.mysql;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

	public boolean createDatabase(String databaseName) {
		boolean success = false ;
		Connection connection = null;
		Statement statement = null;
		try {
			connection = DatabaseConnection.connect(connection);
			String sqlQuery = "create database "+databaseName+";";
			
			if (connection != null) {
				statement = connection.createStatement();
				statement.executeUpdate(sqlQuery);
			} else {
				throw new Exception("Connection string is null");
			}
			
		} catch (Exception ex) {
			System.out.println("EXCEPTION in Database.createDatabase(): "+ex.getMessage());
			ex.printStackTrace();
		} finally {
			try {
				if(statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				System.out.println("EXCEPTION in Database.createDatabase()");
				e.printStackTrace();
			}
			DatabaseConnection.close(connection);
		}
		return success;
	}
}
