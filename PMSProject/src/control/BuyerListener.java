package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Buyer;
import model.OrdinaryBuyerStrategy;
import model.RegisteredBuyer;
import model.RegisteredBuyerStrategy;
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
	private String email;
	private Buyer b;
	
	/**
	 * Constructor for the listener
	 * @param jf the frame that the listener connects to
	 */
	public BuyerListener(BuyerAccountForm jf, int buyerType) {
		if (buyerType == 0) {
			b = new Buyer(new OrdinaryBuyerStrategy());
		}
		else if (buyerType == 1) {
			b = new Buyer(new RegisteredBuyerStrategy());
		}
		frame = jf;
		controller = new BuyerController();
	}
	
	public void Search(int type)
	{
		System.out.println(frame.getSearchPanel().getSearchText());
		ViewDocumentsController d = new ViewDocumentsController();
		frame.getSearchPanel().getList().setText("");
		if(type == 1)
		{	
			for(int i = 0; i < d.getDocumentsByTitle(frame.getSearchPanel().getSearchText()).size(); i++)
			{
				frame.getSearchPanel().getList().append(d.getDocumentsByTitle(frame.getSearchPanel().getSearchText()).get(i).toString() + "\n");
			}
		}
		else if(type == 2)
		{	
			for(int i = 0; i < d.getDocumentsByAuthor(frame.getSearchPanel().getSearchText()).size(); i++)
			{
				frame.getSearchPanel().getList().append(d.getDocumentsByAuthor(frame.getSearchPanel().getSearchText()).get(i).toString() + "\n");
			}
		}
		else if(type == 3)
		{	
			for(int i = 0; i < d.getDocumentsByType(frame.getSearchPanel().getSearchText()).size(); i++)
			{
				frame.getSearchPanel().getList().append(d.getDocumentsByType(frame.getSearchPanel().getSearchText()).get(i).toString() + "\n");
			}
		}
	}
	


	/**
	 * performs an action in response to the event
	 */
	@Override
	public void actionPerformed(ActionEvent a) {
		 
		/**
		 * If search button pressed on home panel
		 */
		if(a.getSource() == frame.getRegHomePanel().getSearch())
		{
			//show the search document frame
			frame.getCardLayout().show(frame.getContentPane(), "Search");
		}
		else if(a.getSource() == frame.getOrdHomePanel().getSearch())
		{
			//show the search document frame
			frame.getCardLayout().show(frame.getContentPane(), "Search");
		}
		/**
		 * If search button pressed on search panel
		 */
		else if(a.getSource() == frame.getSearchPanel().getSearchButton())
		{
			int selection = frame.getSearchPanel().getCheckboxSelection();
			if(selection == 0) 
			{
				System.out.println("Error in Checkbox selected on Search panel");
				System.exit(1);
			}
			Search(selection);
		}
		/**
		 * If back button pressed on search panel
		 */
		else if(a.getSource() == frame.getSearchPanel().getBackButton()) 
		{
			frame.getCardLayout().show(frame.getContentPane(), b.getHomePanel());
		}
		
		
		/**
		 * Make Order
		 */
		else if(a.getSource() == frame.getRegHomePanel().getPlaceOrder())
		{
			//show the add remove frame
			frame.getCardLayout().show(frame.getContentPane(), "Order");
		}
		else if(a.getSource() == frame.getOrdHomePanel().getPlaceOrder())
		{
			//show the add remove frame
			frame.getCardLayout().show(frame.getContentPane(), "Order");
		}
		else if(a.getSource() == frame.getOrderPanel().getMakePayment())
		{
			String email = frame.getOrderPanel().getEmail();
			String item = frame.getOrderPanel().getItem();
			int i = Integer.parseInt(item);
			String quantity = frame.getOrderPanel().getQuantity();
			int q = Integer.parseInt(quantity);
			String cvv = frame.getOrderPanel().getCVV();
			int cv = Integer.parseInt(cvv);
			String card = frame.getOrderPanel().getCard();
			int c = Integer.parseInt(card);
			String type = null;
			if(frame.getOrderPanel().getCheckboxSelection()==1)
			{
				type = "Visa";
			}
			else if(frame.getOrderPanel().getCheckboxSelection()==2)
			{
				type = "Mastercard";
			}
			else if(frame.getOrderPanel().getCheckboxSelection()==3)
			{
				type = "American Express";
			}
			if(!email.equals("") && !item.equals("") && !quantity.equals("") && !cvv.equals("") && !card.equals(""))
			{
				ProcessInventoryController controller = new ProcessInventoryController();
				String reply = controller.makeOrder(type, i, q, cv, c);
				if (reply.equals("not valid id")) {
					JOptionPane.showMessageDialog(null, "Error: The document ID entered does not exist, please try again.", 
							"Error Message", JOptionPane.ERROR_MESSAGE);
				}
				else if (reply.equals("not enough quantity")) {
					JOptionPane.showMessageDialog(null, "Error: The quantity requested for the document selected is not avaliable, please try again.", 
							"Error Message", JOptionPane.ERROR_MESSAGE);
				}
				else if (reply.equals("done")) {
					JOptionPane.showMessageDialog(null, "Success, the order has been placed!", 
							"Message", JOptionPane.INFORMATION_MESSAGE);
				}
			}
			//return to home panel
			frame.getCardLayout().show(frame.getContentPane(), b.getHomePanel());
		}
		
		else if(a.getSource() == frame.getOrderPanel().getBack())
		{
			frame.getCardLayout().show(frame.getContentPane(), b.getHomePanel());
		}
		
		/**
		 * If promotions
		 */
		else if(a.getSource() == frame.getRegHomePanel().getViewPromotions())
		{
			//show the add remove frame
			String string = b.viewPromtions();
			System.out.println(string);
			frame.getCardLayout().show(frame.getContentPane(), string);
		}
		//if remove button on operator home panel pressed is remove document
		else if(a.getSource() == frame.getOrdHomePanel().getViewPromotions())
		{
			//show the please register pop up
			String string = b.viewPromtions();
			JOptionPane.showMessageDialog(null, string, 
					"Error Message", JOptionPane.ERROR_MESSAGE);
		}
		else if(a.getSource() == frame.getPromoPanel().getBack())
		{
			frame.getCardLayout().show(frame.getContentPane(), "Registered Home");
		}
		
		/**
		 * If registration
		 */
		//if remove button on operator home panel pressed is remove document
		else if(a.getSource() == frame.getRegHomePanel().getUnsubscribe())
		{
			controller.deleteRegUser(email); 
			b.setStrategy(new OrdinaryBuyerStrategy());
			frame.getCardLayout().show(frame.getContentPane(), "Ordinary Home");
		}
		//if register button on reg panel pressed 
		else if(a.getSource() == frame.getOrdHomePanel().getRegister())
		{	
			frame.getCardLayout().show(frame.getContentPane(), "Registration");
			
		}
		if(a.getSource() == frame.getRegPanel().getRegister())
		{
			char [] tmp  = frame.getRegPanel().getPasswordField().getPassword();
			String pass = new String (tmp);
			if (!frame.getRegPanel().getEmail().getText().equals("") && !pass.equals("")) {				
				RegisteredBuyer reg = controller.createRegUser(frame.getRegPanel().getEmail().getText(), pass);
				new RegisteredBuyer(reg.getID(), reg.getEmail(), reg.getPassword());
				b.setStrategy(new RegisteredBuyerStrategy());
				frame.getCardLayout().show(frame.getContentPane(), "Registered Home");
			}
		}
		if(a.getSource() == frame.getRegPanel().getBack())
		{
			frame.getCardLayout().show(frame.getContentPane(), "Ordinary Home");
		}
		
		/**
		 * If logout
		 */
		else if(a.getSource() == frame.getRegHomePanel().getLogout()) 
		{
			//exit program
			System.exit(1);
		}
		else if(a.getSource() == frame.getOrdHomePanel().getLogout()) 
		{
			//exit program
			System.exit(1);
		}
	
		
	
	
	}	
	
	public void  setEmail(String s)
	{
		email = s;
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) {

	}
}

