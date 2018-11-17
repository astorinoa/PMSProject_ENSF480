package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;
import view.LoginWindow;
import view.ProfCourseWindow;
import view.StudentCourseWindow;

/**
 * creates an object of type LoginListner which implements ActionListener and is used to 
 * allows JFrame elements to be functional
 * @author Rae McPhail, Alexa Astorino, Shreya Patel
 *
 */
public class LoginListener implements ActionListener{
	private LoginWindow frame;

	/**
	 * Constructor for the listener
	 * @param jf the frame that the listener connects to
	 */

	public LoginListener(LoginWindow jf) {
		frame = jf;
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
		if (!frame.getUserID().getText().equals("")) {
		//	frame.writeObject("searchUserID");
		//	frame.writeObject(frame.getuserEmail().getText()));
			//dont need write object but this is getting the text from the GUI

			String type = (String) frame.readObject();
			if(type.equals("Student")) {
				Student student = (Student) frame.readObject();
				char [] temp = frame.getPasswordField().getPassword();
				String check = new String(temp);
				if (check.equals(student.getPassword())) {
					frame.setVisible(false);
					StudentCourseWindow s = new StudentCourseWindow(student, objOut, objIn);
				}	
				else {			
					JOptionPane.showMessageDialog(null, "Error: Password is incorrect, please try again.", 
							"Error Message", JOptionPane.ERROR_MESSAGE);
				}
			}
			else if(type.equals("Prof"))
			{
				Prof prof = (Prof) frame.readObject();
				char [] temp = frame.getPasswordField().getPassword();
				String check = new String(temp);
				if (check.equals(prof.getPassword())) {
					frame.setVisible(false);
					ProfCourseWindow p = new ProfCourseWindow(prof, objOut, objIn);
				}
				else {			
					JOptionPane.showMessageDialog(null, "Error: Password is incorrect, please try again.", 
							"Error Message", JOptionPane.ERROR_MESSAGE);
				}
			}
			else if(type.equals("NoUser"))
			{
				JOptionPane.showMessageDialog(null, "Error: User ID does not match anyone in the record, please try again.", 
						"Error Message", JOptionPane.ERROR_MESSAGE);
			}

		}
	}

}
