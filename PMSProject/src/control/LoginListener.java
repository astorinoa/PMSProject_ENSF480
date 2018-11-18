package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;

import view.BuyerAccountForm;
import view.LoginForm;
import view.OperatorActionForm;
import model.RegisteredBuyer;

/**
 * creates an object of type LoginListner which implements ActionListener and is used to 
 * allows JFrame elements to be functional
 * @author Rae McPhail, Alexa Astorino, Shreya Patel
 *
 */
public class LoginListener implements ActionListener{
	private LoginForm frame;
	private ValidateLoginController validate;

	/**
	 * Constructor for the listener
	 * @param jf the frame that the listener connects to
	 */

	public LoginListener(LoginForm jf){
		frame = jf;
		validate = new ValidateLoginController();
	}

	/**
	 * performs an action in response to the event
	 */
	@Override
	public void actionPerformed(ActionEvent a) {
		if (a.getSource() == frame.getLogin()) {		
			userSearch();
		}
		if (a.getSource() == frame.getGuest()) {	
			frame.setVisible(false);
			BuyerAccountForm b = new BuyerAccountForm();
			b.getCardLayout().show(b.getContentPane(), "Ordinary Home");	
		}
	}

	/**
	 * communicates with backend to search for what user type is trying to login
	 */
	public void userSearch() {
		if (!frame.getuserEmail().getText().equals("")) {
			char [] tmp = frame.getPasswordField().getPassword();
			String pass = new String (tmp);
			String type = validate.readCheck(frame.getuserEmail().getText(), pass);
			if(type.equals("RegisteredBuyer")) {
				frame.setVisible(false);
				BuyerAccountForm r = new BuyerAccountForm();
			}
			else if(type.equals("Operator"))
			{
				frame.setVisible(false);
				OperatorActionForm p = new OperatorActionForm();
			}
			else if(type.equals("NoUser"))
			{
				JOptionPane.showMessageDialog(null, "Error: User email and/or password does not match anyone in the PMS, please try again.", 
						"Error Message", JOptionPane.ERROR_MESSAGE);
			}

		}
	}

}
