package model;

public class RegisteredBuyer extends Buyer{
	
	public RegisteredBuyer(int id, String email, String password) {
		super(id,email,password);
		strategy = new RegisteredBuyerStrategy();
	}

}
