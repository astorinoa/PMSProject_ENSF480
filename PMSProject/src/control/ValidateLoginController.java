package control;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.*;

public class ValidateLoginController extends Driver{
	/**
	 * have access to the database
	 */
	public ValidateLoginController(){
		super();
	}
	
	/**
	 * check type of user
	 * @param email of user
	 * @param password of user
	 * @return type of user
	 */
	public String readCheck(String email, String password){
		RegisteredBuyer buyer = searchRegUser(email, password);
		if (buyer != null) {
			return "RegisteredBuyer";
		}
		Operator operate = searchOperator(email, password);
		if (operate != null) {
			return "Operator";
		}
		return "NoUser";
	}
	
	/**
	 * search for registered user
	 * @param email of user
	 * @param password of user
	 * @return registered user type
	 */
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
	
	/**
	 * search for operator user
	 * @param email of user
	 * @param password of user
	 * @return operator user type
	 */
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
