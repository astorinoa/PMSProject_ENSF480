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
	

	public String viewPromotions()
	{
		return "Please register to view promotions!";
		
	}
	

	public void changeSubscriptionStatus()
	{
		//shows "Not a registered buyer"
	}
	
	public int getNumber()
	{
		return 0;
	}
}