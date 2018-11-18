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
abstract class Buyer {
	
	protected BuyerStrategy strategy;
	protected String email;
	protected String password;
	protected int id;
	
	/**
	 * Constructor for the Buyer if they logged in as a RegisteredBuyer, 
	 * you know they are a registered buyer because they have an email and password
	 * @param e is the operator's email address
	 * @param p is the operator's password
	 * @param id is the operator's id in the database
	 */
	public Buyer(int id, String e, String p) {
		this.id = id;
		email = e;
		password = p;
		//strategy = new RegisteredBuyer();
	}
	
//	/**
//	 * Constructor for the Buyer if they are browser as an OrdinaryBuyer, 
//	 * you know they are an ordinary buyer because they don't have an email and password
//	 */
//	public Buyer() {
//		this.id = null;
//		email = null;
//		password = null;
//		strategy = new OrdinaryBuyer();
//	}
	
//	/**
//	 * sets Buyer strategy
//	 */
//	public void setStrategy(Strategy s)
//	{
//		strategy = s; 
//	}
	
	/**
	 * allows buyer to view promotions, 
	 * different method is called depending on which strategy is being used
	 */
	public void viewPromtions ()
	{
		strategy.viewPromotions();
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
	
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public int getID() {
		return id;
	}
}