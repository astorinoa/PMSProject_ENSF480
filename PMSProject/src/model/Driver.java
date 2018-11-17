package model;

import java.sql.*;

/**
 * Enables connection to the database
 * @author Shreya Patel, Alexa Astorino, Rae Mcphail
 *
 */
public class Driver {
	protected Connection conn;
	protected Statement stmt;
	public String databaseName = "pms_ensf480";
	
	
	public String connectionInfo = "jdbc:mysql://localhost:3306/pms_ensf480?useSSL=false",  
			  login          = "root",
			  password       = "HelloWorld";
		
	protected String docTable = "document", operatorTable = "operator", orderTable = "order",
			promoTable = "promotion", regTable = "registered_buyer";
	
	/**
	 * Constructor for Driver class. Enables the connection to the database.
	 */
	public Driver()
	{
		try{
			// If this throws an error, make sure you have added the mySQL connector JAR to the project
			Class.forName("com.mysql.jdbc.Driver");
			
			// If this fails make sure your connectionInfo and login/password are correct
			conn = DriverManager.getConnection(connectionInfo, login, password);
			System.out.println("Connected to: " + connectionInfo + "\n");
		}
		catch(SQLException e) { e.printStackTrace(); }
		catch(Exception e) { e.printStackTrace(); }
		
	}	
}


