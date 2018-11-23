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
	private String email;
	
	/**
	 * Constructor for the listener
	 * @param jf the frame that the listener connects to
	 */
	public BuyerListener(BuyerAccountForm jf) {
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
		 * If search
		 */
		//if search button on buyer home panel pressed is search documents
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
		 * If search button pressed
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
		 * If promotions
		 */
		//if remove button on operator home panel pressed is remove document
		else if(a.getSource() == frame.getRegHomePanel().getViewPromotions())
		{
			//show the add remove frame
			frame.getCardLayout().show(frame.getContentPane(), "Promotion");
		}
		//if remove button on operator home panel pressed is remove document
		else if(a.getSource() == frame.getOrdHomePanel().getViewPromotions())
		{
			//show the add remove frame
			frame.getCardLayout().show(frame.getContentPane(), "Promotion");
		}
		
		/**
		 * If registration
		 */
		//if remove button on operator home panel pressed is remove document
		else if(a.getSource() == frame.getRegHomePanel().getUnsubscribe())
		{
			System.out.println(email);
			controller.deleteRegUser(email); 
			frame.getCardLayout().show(frame.getContentPane(), "Ordinary Home");
		}
		//if register button on reg panel pressed 
		else if(a.getSource() == frame.getOrdHomePanel().getRegister())
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
	
		
		
	/**
		//if logout button on buyer home panel pressed
		else if(a.getSource() == frame.getRegHomePanel().getLogout()) 
		{
			//exit program
			System.exit(1);
		}
		
	
		//if remove button on operator home panel pressed is remove document
		else if(a.getSource() == frame.getOrdHomePanel().getRegister())
		{
			//delete account and go to ordinary home page
			
			frame.getCardLayout().show(frame.getContentPane(), "Ordinary Home");
		}
			else if(a.getSource() == frame.getOrdHomePanel().getRegister())
		{
			System.out.println("Trying to register");
			frame.getCardLayout().show(frame.getContentPane(), "Registration");
		}
		//if logout button on buyer home panel pressed
		else if(a.getSource() == frame.getOrdHomePanel().getLogout()) 
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
		
		
	
		
	*/	
		
	
	
	}	
	
	public void  setEmail(String s)
	{
		email = s;
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) {

	}
}

