package model;

public class OrdinaryBuyer extends Buyer {
	
	public OrdinaryBuyer() {
		super(new OrdinaryBuyerStrategy());
	}

}
