package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;

import model.RegisteredBuyer;
import view.LoginWindow;
import view.OperatorWindow;

/**
 * creates an object of type LoginListner which implements ActionListener and is used to 
 * allows JFrame elements to be functional
 * @author Rae McPhail, Alexa Astorino, Shreya Patel
 *
 */
public class LoginListener implements ActionListener{
	private LoginWindow frame;
	private ValidateLoginController validate;

	/**
	 * Constructor for the listener
	 * @param jf the frame that the listener connects to
	 */

	public LoginListener(LoginWindow jf){
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
	}

	/**
	 * communicates with backend to search for what user type is trying to login
	 */
	public void userSearch() {
		if (!frame.getuserEmail().getText().equals("")) {
			char [] tmp = frame.getPasswordField().getPassword();
			String pass = new String (tmp);
			String type = validate.readCheck(frame.getuserEmail().getText(), pass);
			System.out.println(type);
			if(type.equals("RegisteredBuyer")) {
	//			RegisteredWindow r = new RegisteredWindow();
			}
			else if(type.equals("Operator"))
			{
				OperatorWindow p = new OperatorWindow();
			}
			else if(type.equals("NoUser"))
			{
				JOptionPane.showMessageDialog(null, "Error: User ID does not match anyone in the record, please try again.", 
						"Error Message", JOptionPane.ERROR_MESSAGE);
			}

		}
	}

}
