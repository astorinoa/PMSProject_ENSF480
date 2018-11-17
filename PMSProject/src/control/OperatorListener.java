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
		if(a.getSource() == frame.getOperatorHomePanel.getAdd())
		{
			//show the add document frame
		}
		//if update button on operator home panel pressed is update document
		else if(a.getSource() == frame.getOperatorHomePanel.getUpdate())
		{
			//show the update document frame
		}
		//if remove button on operator home panel pressed is remove document
		else if(a.getSource() == frame.getOperatorHomePanel.getRemove())
		{
			//show the add remove frame
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}

