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
	abstract String viewPromotions();//returns different strings based on strategy
	abstract void changeSubscriptionStatus();
	abstract int getNumber();
}
