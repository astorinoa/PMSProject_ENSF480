package control;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.ApprovalDocument;
import model.RegisteredBuyer;

public class BuyerController extends Driver{
	
	/**
	 * have access to the database
	 */
	public BuyerController(){
		super();
	}
	
	/**
	 * creates a user account, but checks to make sure it doesn't already exist
	 * @param email of the user
	 * @param password of the user
	 * @return registeredBuyer object
	 */
	public RegisteredBuyer createRegUser(String email, String password)
	{	
		String sql = "SELECT * FROM " + regTable + " WHERE EMAIL = '" + email + "' AND PASSWORD = '" + password + "'";
		RegisteredBuyer r = null;
		ResultSet user;
		try {
			stmt = conn.createStatement();
			user = stmt.executeQuery(sql);
			if(user.next())
			{
				r= new RegisteredBuyer(user.getInt("BUYER_ID"),
						user.getString("EMAIL"),
						user.getString("PASSWORD"));
			}

		} catch (SQLException e) { e.printStackTrace(); }
		
		if (r == null){
		
			String sql2 = "INSERT INTO " + regTable +
					" (`email`, `password`) VALUES ( '"+ email +"', '" + 
					password + "' )";
			try{
				stmt = conn.createStatement();
				stmt.executeUpdate(sql2);
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			
			String sql3 = "SELECT * FROM " + regTable + " WHERE EMAIL = '" + email + "' AND PASSWORD = '" + password + "'";
			ResultSet user2;
			try {
				stmt = conn.createStatement();
				user2 = stmt.executeQuery(sql3);
				if(user2.next())
				{
					return new RegisteredBuyer(user2.getInt("BUYER_ID"),
							user2.getString("EMAIL"),
							user2.getString("PASSWORD"));
				}
	
			} catch (SQLException e) { e.printStackTrace(); }		
		}
		else {
			return r;
		}
		return null;
	}
	
	/**
	 * delete the registered user
	 * @param email of the user
	 */
	public void deleteRegUser (String email){
		System.out.println("In controller: " + email);
		String sql = "DELETE FROM " + regTable + " WHERE EMAIL= '" + email + "'";
		try{
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		
	}
	
}
