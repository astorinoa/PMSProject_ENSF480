package control;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Driver;

public class ValidateLoginController extends Driver{
	
	public ValidateLoginController(){
		super();
	}
	
	public String readCheck(String email, String password){
		
		
	}
	
	public RegisteredBuyer searchStudentUserID(int userId)
	{
		String sql = "SELECT * FROM " + regTable + " WHERE ID=" + userId;
		ResultSet user;
		try {
			stmt = conn.createStatement();
			user = stmt.executeQuery(sql);
			if(user.next())
			{
				return new Student(user.getInt("ID"),
						user.getString("PASSWORD"), 
						user.getString("EMAIL"), 
						user.getString("FIRSTNAME"), 
						user.getString("LASTNAME"));
			}

		} catch (SQLException e) { e.printStackTrace(); }
		return null;
	}
	
}
