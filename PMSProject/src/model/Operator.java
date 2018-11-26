package model;
import java.lang.*;

/**Models an operator, operators are able to add, update and remove documents. 
 * They have login information stored in the database
 * @author Alexa Astorino, Shreya Patel, Rae McPhail
 */
public class Operator {
	private String email;
	private String password;
	private int id;
	
	/**
	 * Constructor for the operator
	 * @param e is the operator's email address
	 * @param p is the operator's password
	 */
	public Operator(int id, String e, String p) {
		this.id = id;
		email = e;
		password = p;
	}	
	
	public String getEmail() {
		return email;
	}
}
