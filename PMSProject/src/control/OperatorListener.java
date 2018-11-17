package control;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import view.LoginWindow;
import view.OperatorHomePanel;
import view.OperatorWindow;


/**
 * creates an object of type OperatorListener which implements ActionListener and is used to 
 * allows JFrame elements to be functional
 * @author Rae McPhail, Alexa Astorino, Shreya Patel
 *
 */
public class OperatorListener implements ActionListener, ListSelectionListener{
	private OperatorWindow frame;

	/**
	 * Constructor for the listener
	 * @param jf the frame that the listener connects to
	 */
	public OperatorListener(OperatorWindow jf) {
		frame = jf;
	}

	/**
	 * performs an action in response to the event
	 */
	@Override
	public void actionPerformed(ActionEvent a) {
		//if add button on operator home panel pressed is add document
		if(a.getSource() == frame.getOperatorHomePanel().getAdd())
		{
			//show the add document frame
			frame.getCardLayout().show(frame.getContentPane(), "Add Documents");
		}
		//if update button on operator home panel pressed is update document
		else if(a.getSource() == frame.getOperatorHomePanel().getUpdate())
		{
			//show the update document frame
			frame.getCardLayout().show(frame.getContentPane(), "Update Documents");
		}
		//if remove button on operator home panel pressed is remove document
		else if(a.getSource() == frame.getOperatorHomePanel().getRemove())
		{
			//show the add remove frame
			frame.getCardLayout().show(frame.getContentPane(), "Remove Documents");
		}
		//if logout button on operator home panel pressed
		else if(a.getSource() == frame.getOperatorHomePanel().getLogout()) 
		{
			//exit program
			System.exit(1);
		}
		
		//if back button on add document panel pressed 
		else if(a.getSource() == frame.getAddDocPanel().getBack())
		{
			//show the home panel
			frame.getCardLayout().show(frame.getContentPane(), "Home");	
		}
	
		//if back button on add document panel pressed 
		else if(a.getSource() == frame.getUpdateDocPanel().getBack())
		{
			//show the home panel
			frame.getCardLayout().show(frame.getContentPane(), "Home");	
		}

		//if back button on add document panel pressed 
		else if(a.getSource() == frame.getRemoveDocPanel().getBack())
		{
			//show the home panel
			frame.getCardLayout().show(frame.getContentPane(), "Home");
		}
	}	
	
	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}

