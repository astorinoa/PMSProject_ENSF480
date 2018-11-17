package control;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.*;

public class ValidateLoginController extends Driver{
	
	public ValidateLoginController(){
		super();
	}
	
	public String readCheck(String email, String password){
		System.out.println(email);
		System.out.println(password);
		RegisteredBuyer buyer = searchRegUser(email, password);
		if (buyer != null) {
			return "RegisteredBuyer";
		}
		Operator operate = searchOperator(email, password);
		if (operate != null) {
			System.out.println("*****************");
			return "Operator";
		}
		return "NoUser";
	}
	
	public RegisteredBuyer searchRegUser(String email, String password)
	{
		String sql = "SELECT * FROM " + regTable + " WHERE EMAIL = '" + email + "' AND PASSWORD = '" + password + "'";
		ResultSet user;
		try {
			stmt = conn.createStatement();
			user = stmt.executeQuery(sql);
			if(user.next())
			{
				return new RegisteredBuyer(user.getInt("BUYER_ID"),
						user.getString("EMAIL"),
						user.getString("PASSWORD"));
			}

		} catch (SQLException e) { e.printStackTrace(); }
		return null;
	}
	
	
	public Operator searchOperator(String email, String password)
	{
		String sql = "SELECT * FROM " + operatorTable + " WHERE EMAIL = '" + email + "' AND PASSWORD = '" + password + "'";
		ResultSet user;
		try {
			stmt = conn.createStatement();
			user = stmt.executeQuery(sql);
			if(user.next())
			{
				return new Operator(user.getInt("OPERATOR_ID"),
						user.getString("EMAIL"),
						user.getString("PASSWORD"));
			}

		} catch (SQLException e) { e.printStackTrace(); }
		return null;
	}
	
}
