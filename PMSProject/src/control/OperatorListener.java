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
 * creates an object of type OperatorListener which implements ActionListener and is used to 
 * allows JFrame elements to be functional
 * @author Rae McPhail, Alexa Astorino, Shreya Patel
 *
 */
public class OperatorListener implements ActionListener{
	private OperatorHomePanel frame;

	/**
	 * Constructor for the listener
	 * @param jf the frame that the listener connects to
	 */
	public OperatorListener(Window jf) {
		frame = jf;
	}

	/**
	 * performs an action in response to the event
	 */
	@Override
	public void actionPerformed(ActionEvent a) {
		//if button pressed is add document
		if(a.getSource() == frame.getAdd())
		{
			//show the add document frame
		}
		//if button pressed is update document
		else if(a.getSource() == frame.getUpdate())
		{
			//show the update document frame
		}
		//if button pressed is remove document
		else if(a.getSource() == frame.getRemove())
		{
			//show the add remove frame
		}
	}
	}
}
