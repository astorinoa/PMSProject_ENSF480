package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.RegisteredBuyer;
import view.BuyerAccountForm;

/**
 * creates an object of type RegisteredHomePanel which implements ActionListener and is used to 
 * allows JFrame elements to be functional
 * @author Rae McPhail, Alexa Astorino, Shreya Patel
 *
 */
public class BuyerListener implements ActionListener, ListSelectionListener{
	private BuyerAccountForm frame;
	private BuyerController controller;
	/**
	 * Constructor for the listener
	 * @param jf the frame that the listener connects to
	 */
	public BuyerListener(BuyerAccountForm jf) {
		frame = jf;
		controller = new BuyerController();
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
		
		
		//if back button on reg panel pressed 
		else if(a.getSource() == frame.getRegPanel().getBack())
		{
			//show the home panel
			frame.getCardLayout().show(frame.getContentPane(), "Ordinary Home");	
		}
		//if register button on reg panel pressed 
		else if(a.getSource() == frame.getRegPanel().getRegister())
		{
			char [] tmp  = frame.getRegPanel().getPasswordField().getPassword();
			String pass = new String (tmp);
			if (!frame.getRegPanel().getEmail().getText().equals("") && !pass.equals("")) {				
				RegisteredBuyer reg = controller.createRegUser(frame.getRegPanel().getEmail().getText(), pass);
				new RegisteredBuyer(reg.getID(), reg.getEmail(), reg.getPassword());
				//show the registered home panel
				frame.getCardLayout().show(frame.getContentPane(), "Registered Home");
			}
		}
		
		else if(a.getSource() == frame.getOrdHomePanel().getRegister())
		{
			frame.getCardLayout().show(frame.getContentPane(), "Registration");
		}
		
		
	
	
	}	
	
	@Override
	public void valueChanged(ListSelectionEvent e) {

	}
}

