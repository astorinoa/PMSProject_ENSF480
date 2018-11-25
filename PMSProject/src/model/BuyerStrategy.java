package model;

/**
 * creates an object of type BuyerStrategy which uses Strategy pattern. A buyer will either be
 * a registered buyer or an ordinary buyer. Registered buyers can see promotions when they 
 * try and view promotions, ordinary buyers cannot and will be told to register in 
 * order to see promotions. Registered buyers become ordinary buyers when changeSubscriptionstatus
 * is called. Ordinary buyers become registered buyers when changeSubscriptionstatus
 * is called.
 * @author Rae McPhail, Alexa Astorino, Shreya Patel
 *
 */
public interface BuyerStrategy {
	/** 
	 * @return string of the message that the buyer views
	 */
	abstract String viewPromotions();
	
	/**
	 * @return 1 if strategy is registered, 0 if strategy is ordinary
	 */
	abstract int getNumber();
	
	/**
	 * @return string for the home panel of the buyer based on which strategy they are implementing
	 */
	abstract String getHomePanel();
}
