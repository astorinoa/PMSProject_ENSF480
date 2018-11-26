package model;

/**
 * Models a buyer that has a default buyer strategy as ordinary.
 * @author Rae McPhail, Alexa Astorino, Shreya Patel
 */
public class OrdinaryBuyer extends Buyer {
	
	/**
	 * Constructs an ordinary buyer
	 */
	public OrdinaryBuyer() {
		super(new OrdinaryBuyerStrategy());
	}

}
