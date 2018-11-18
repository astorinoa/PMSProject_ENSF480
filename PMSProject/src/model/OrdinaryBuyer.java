package model;

public class OrdinaryBuyer extends Buyer {
	
	public OrdinaryBuyer(int id, String email, String password) {
		super(id,email,password);
		strategy = new OrdinaryBuyerStrategy();
	}

}
