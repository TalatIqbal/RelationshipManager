package ca.allyengine.database.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class InformationSchema {

	public static void query(String databaseName) {

		Connection connection = null;
		try {
			connection = DatabaseConnection.connect(connection,databaseName);
			Statement statement = connection.createStatement();  
			ResultSet resultSet = statement.executeQuery("select * from information_schema.tables");  
			
			while(resultSet.next()) {
				System.out.println(resultSet.getString(1)+"  "+resultSet.getString(2)+"  "+resultSet.getString(3));
			}
		} catch (Exception ex) {
			System.out.println("EXCEPTION in InformationSchema.query()");
			ex.printStackTrace();
		}finally {
			DatabaseConnection.close(connection);
		}
	}
}
