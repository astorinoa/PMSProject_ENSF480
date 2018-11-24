package model;

public class RegisteredBuyerStrategy implements BuyerStrategy {
	

	/**
	 * allows buyer to view promotions, 
	 * only registered buyers are able to see promotions
	 */
	public String viewPromotions()
	{
		return "Promotion";
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
	
	public int getNumber()
	{
		return 1;
	}
	
	public String getHomePanel()
	{
		return "Registered Home";
	}
}


