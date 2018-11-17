package model;

public class RegisteredBuyer {
	private String email;
	private String password;
	private int id;
	
	/**
	 * Constructor for the RegisteredBuyer
	 * @param e is the operator's email address
	 * @param p is the operator's password
	 */
	public RegisteredBuyer(int id, String e, String p) {
		this.id = id;
		email = e;
		password = p;
	}	
	
	public String getEmail() {
		return email;
	}
}
