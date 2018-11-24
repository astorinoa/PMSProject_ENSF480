package model;

public class RegisteredBuyer extends Buyer{
	private String email;
	private String password;
	private int id;
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
