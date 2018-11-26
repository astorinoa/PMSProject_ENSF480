package model;

/**
 * Defines strategy pattern methods as they should be for registered buyers
 * @author Rae McPhail, Alexa Astorino, Shreya Patel
 */
public class RegisteredBuyerStrategy implements BuyerStrategy {

	/**
	 * @return name of the promotion panel that allows registered buyers to view promotions
	 */
	public String viewPromotions()
	{
		return "Promotion";
	}
	
	/**
	 *  @ returns 1 to communicate that the strategy is registered buyer
	 */
	public int getNumber()
	{
		return 1;
	}
	
	/**
	 *  @ returns name of the registered buyer home panel
	 */
	public String getHomePanel()
	{
		return "Registered Home";
	}
}


