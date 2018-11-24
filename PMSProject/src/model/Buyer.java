package model;

/**
 * creates an object of type Buyer which uses Strategy pattern. A buyer will either be
 * a registered buyer or an ordinary buyer. Registered buyers can see promotions when they 
 * try and view promotions, ordinary buyers cannot and will be told to register in 
 * order to see promotions. Registered buyers become ordinary buyers when changeSubscriptionstatus
 * is called. Ordinary buyers become registered buyers when changeSubscriptionstatus
 * is called.
 * @author Rae McPhail, Alexa Astorino, Shreya Patel
 *
 */
public class Buyer {
	
	protected BuyerStrategy strategy;
	
	/**
	 * Constructor for the Buyer if they are browser as an OrdinaryBuyer, 
	 * you know they are an ordinary buyer because they don't have an email and password
	 */
	public Buyer(BuyerStrategy s) {
		strategy = s;
	}
	
	public BuyerStrategy getStrategy() {
		return strategy;
	}
	
	
	/**
	 * allows buyer to view promotions, 
	 * different method is called depending on which strategy is being used
	 * @return 
	 */
	public String viewPromtions ()
	{
		return strategy.viewPromotions();
	}
	
	/**
	 * different method is called depending on which strategy is being used,
	 * registered buyers become ordinary buyers when this method is called
	 * ordinary buyers become registered buyers when this method is called
	 */
	public void changeSubscriptionStatus ()
	{
		strategy.changeSubscriptionStatus();
	}
	
	
	public int getStrategyNumber()
	{
		return strategy.getNumber();
	}

}