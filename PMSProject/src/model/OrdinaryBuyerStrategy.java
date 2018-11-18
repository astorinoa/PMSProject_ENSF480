package model;

/**
 * creates an object of type OrdinaryBuyer which is a strategy for BuyerStrategy. 
 * Ordinary buyers cannot see promotions and will be told to register in 
 * order to see promotions. Ordinary buyers become registered buyers when 
 * changeSubscriptionstatusis called.
 * @author Rae McPhail, Alexa Astorino, Shreya Patel
 *
 */
public class OrdinaryBuyerStrategy implements BuyerStrategy {
	

	public void viewPromotions()
	{
		//potentially call method in listener
		//shows "Become a registered buyer to receive promotions"
	}
	

	public void changeSubscriptionStatus()
	{
		//shows "Not a registered buyer"
	}
}