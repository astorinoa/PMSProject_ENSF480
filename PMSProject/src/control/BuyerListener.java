package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import view.BuyerAccountForm;

/**
 * creates an object of type RegisteredHomePanel which implements ActionListener and is used to 
 * allows JFrame elements to be functional
 * @author Rae McPhail, Alexa Astorino, Shreya Patel
 *
 */
public class BuyerListener implements ActionListener, ListSelectionListener{
	private BuyerAccountForm frame;

	/**
	 * Constructor for the listener
	 * @param jf the frame that the listener connects to
	 */
	public BuyerListener(BuyerAccountForm jf) {
		frame = jf;
	}

	/**
	 * performs an action in response to the event
	 */
	@Override
	public void actionPerformed(ActionEvent a) {
		
		//if search button on buyer home panel pressed is search documents
		if(a.getSource() == frame.getRegHomePanel().getSearch())
		{
			//show the search document frame
			frame.getCardLayout().show(frame.getContentPane(), "Search");
		}
		//if place order button on buyer home panel pressed, can place order
//		else if(a.getSource() == frame.getRegHomePanel().getPlaceOrder())
//		{
//			//show the update document frame
//			frame.getCardLayout().show(frame.getContentPane(), "Place Order");
//		}
		//if remove button on operator home panel pressed is remove document
		else if(a.getSource() == frame.getRegHomePanel().getViewPromotions())
		{
			//show the add remove frame
			frame.getCardLayout().show(frame.getContentPane(), "Promotion");
		}
		//if remove button on operator home panel pressed is remove document
		else if(a.getSource() == frame.getRegHomePanel().getUnsubscribe())
		{
			//delete account and go to ordinary home page
			
			frame.getCardLayout().show(frame.getContentPane(), "Ordinary Home");
		}
		//if logout button on buyer home panel pressed
		else if(a.getSource() == frame.getRegHomePanel().getLogout()) 
		{
			//exit program
			System.exit(1);
		}
		
		
		//if back button on add document panel pressed 
		else if(a.getSource() == frame.getRegPanel().getBack())
		{
			//show the home panel
			frame.getCardLayout().show(frame.getContentPane(), "Home");	
		}
	
	
	}	
	
	@Override
	public void valueChanged(ListSelectionEvent e) {

	}
}

