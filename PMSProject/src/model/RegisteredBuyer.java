package model;

/**
 * Models a buyer that has a default buyer strategy as registered. 
 * Registered buyers are added to the database so that their login credentials can be validated
 * @author Rae McPhail, Alexa Astorino, Shreya Patel
 */
public class RegisteredBuyer extends Buyer{
	private String email;
	private String password;
	private int id;
	
	/**
	 * Constructs a registered buyer
	 * @param id regsitered buyer's id in the database
	 * @param email registered buyer's email
	 * @param password registered buyer's password
	 */
	public RegisteredBuyer(int id, String email, String password) {
		super(new RegisteredBuyerStrategy());
		this.id = id;
		this.email = email;
		this.password = password;
	}
	
public String getEmail() {
	return email;
}

public String getPassword() {
	return password;
}

public int getID() {
	return id;
}

}
