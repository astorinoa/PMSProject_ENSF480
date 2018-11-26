package model;

import view.OrdinaryHomePanel;
import view.RegisteredHomePanel;

/**
 * creates an object of type OrdinaryBuyerStra which is a strategy for BuyerStrategy. 
 * Ordinary buyers cannot see promotions and will be told to register in 
 * order to see promotions. Ordinary buyers become registered buyers when 
 * changeSubscriptionstatusis called.
 * @author Rae McPhail, Alexa Astorino, Shreya Patel
 *
 */
public class OrdinaryBuyerStrategy implements BuyerStrategy {
	
	/**
	 * @return string that the ordinary buyer views when they try to view promotions
	 */
	public String viewPromotions()
	{
		return "Please register to view promotions!";	
	}
	
	/**
	 *  @ returns 0 to communicate that the strategy is ordinary buyer
	 */
	public int getNumber()
	{
		return 0;
	}
	
	/**
	 *  @ returns name of the ordinary buyer home panel
	 */
	public String getHomePanel()
	{
		return "Ordinary Home";
	}
}