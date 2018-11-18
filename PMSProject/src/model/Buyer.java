package model;

public class Buyer {
	
	private BuyerStrategy strategy;
	private String email;
	private String password;
	private int id;
	
	/**
	 * Constructor for the RegisteredBuyer
	 * @param e is the operator's email address
	 * @param p is the operator's password
	 */
	public Buyer(int id, String e, String p) {
		this.id = id;
		email = e;
		password = p;
		strategy = new RegisteredBuyer();
	}
	
	public Buyer() {
		this.id = null;
		email = null;
		password = null;
		strategy = new OrdinaryBuyer();
	}
	
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public String getID() {
		return id;
	}
}