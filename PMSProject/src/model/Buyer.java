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
	
	/**
	 * Allows the buyer to change from being registered or ordinary dynamically using Strategy pattern
	 * @param bs the buyer strategy
	 */
	public void setStrategy(BuyerStrategy bs) {
		strategy = bs;
	}
	
	
	/**
	 * allows buyer to view promotions, 
	 * different method is called depending on which strategy is being used
	 * @return a string that the buyer will view, either the list of promotions if they are registered
	 * 			or a message telling them to register to see promotions if they are ordinary
	 */
	public String viewPromtions ()
	{
		return strategy.viewPromotions();
	}
	
	
	/**
	 * Communicates which strategy is being used, this method was primarily implemented to avoid violating package dependencies
	 * @return 1 if the buyer strategy is registered, 0 if the buyer strategy is ordinary
	 */
	public int getStrategyNumber()
	{
		return strategy.getNumber();
	}
	
	/**
	 * Communicates which home panel to return to based on the strategy implemented
	 * @return Registered if the buyer strategy is registered buyer, returns ordinary if the buyer strategy is ordinary.
	 * 			The string is used in the GUI to determine which panel to display
	 */
	public String getHomePanel()
	{
		return strategy.getHomePanel();
	}

}