package model;

public class RegisteredBuyerStrategy implements BuyerStrategy {
	
//	Buyer b;
//	public RegisteredBuyerStrategy(Buyer b)
//	{
//		this.b = b;
//	}
	


	/**
	 * allows buyer to view promotions, 
	 * only registered buyers are able to see promotions
	 */
	public void viewPromotions()
	{
		//shows "Become a registered buyer to receive promotions"
	}
	
	/**
	 * allows buyer to view change their strategy
	 * for registered buyers they become ordinary buyers
	 */
	public void changeSubscriptionStatus()
	{
		//help
		//b.setStrategyPattern(new OrdinaryBuyer());
		//Makes buyer a registered buyer
		//TODO update database
	}
}


