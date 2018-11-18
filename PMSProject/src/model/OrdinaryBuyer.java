package model;

/**
 * creates an object of type OrdinaryBuyer which is a strategy for BuyerStrategy. 
 * Ordinary buyers cannot see promotions and will be told to register in 
 * order to see promotions. Ordinary buyers become registered buyers when 
 * changeSubscriptionstatusis called.
 * @author Rae McPhail, Alexa Astorino, Shreya Patel
 *
 */
public class OrdinaryBuyer implements BuyerStrategy {
	
	Buyer b;
	public OrdinaryBuyer(Buyer b)
	{
		this.b = B;
	}
	
	/**
	 * allows buyer to view promotions, 
	 * for ordinary buyers shows a window that tells them to become
	 * a registered buyer in order to see promotions
	 */
	public void viewPromotions()
	{
		//shows "Become a registered buyer to receive promotions"
	}
	
	/**
	 * allows buyer to view change their strategy
	 * for ordinary buyers they become registered buyers
	 */
	public void changeSubscriptionStatus()
	{
		b.setStrategyPattern(new RegisterBuyer());
		//Makes buyer a registered buyer
		//TODO update database
	}
}