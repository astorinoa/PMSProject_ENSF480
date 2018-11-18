package control;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.ApprovalDocument;
import model.Document;
import view.OperatorActionForm;


/**
 * creates an object of type OperatorListener which implements ActionListener and is used to 
 * allows JFrame elements to be functional
 * @author Rae McPhail, Alexa Astorino, Shreya Patel
 *
 */
public class OperatorListener implements ActionListener, ListSelectionListener{
	private OperatorActionForm frame;

	/**
	 * Constructor for the listener
	 * @param jf the frame that the listener connects to
	 */
	public OperatorListener(OperatorActionForm jf) {
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
	
		//if back button on update document panel pressed 
		else if(a.getSource() == frame.getUpdateDocPanel().getBack())
		{
			//show the home panel
			frame.getCardLayout().show(frame.getContentPane(), "Home");	
		}

		//if back button on remove document panel pressed 
		else if(a.getSource() == frame.getRemoveDocPanel().getBack())
		{
			//show the home panel
			frame.getCardLayout().show(frame.getContentPane(), "Home");
		}
	}	
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (e.getValueIsAdjusting()) {
			EditDocumentController d = new EditDocumentController();
			
			// remove document
			if (e.getSource() == frame.getRemoveDocPanel().getDocuments()) {
				if(frame.getRemoveDocPanel().getDocuments().getSelectedIndex() != -1)
				{
					Document doomed = d.getDocuments().get(frame.getRemoveDocPanel().getDocuments().getSelectedIndex());
					d.deleteDocument(doomed);
					
					frame.getRemoveDocPanel().getModel().removeAllElements();
					
					for(int i = 0; i < d.getDocuments().size(); i++)
					{
						frame.getRemoveDocPanel().getModel().addElement(d.getDocuments().get(i).toString());
					}
				}
			}
			// add document from the approval queue
			if (e.getSource() == frame.getAddDocPanel().getDocuments()) {
				if(frame.getAddDocPanel().getDocuments().getSelectedIndex() != -1)
				{
					ApprovalDocument add = d.getApprovalDocuments().get(frame.getAddDocPanel().getDocuments().getSelectedIndex());
					d.addDocument(add);
					d.deleteDocument(add);
					
					frame.getAddDocPanel().getModel().removeAllElements();
					for(int i = 0; i < d.getApprovalDocuments().size(); i++)
					{
						frame.getAddDocPanel().getModel().addElement(d.getApprovalDocuments().get(i).toString());
					}
					
					frame.getRemoveDocPanel().getModel().removeAllElements();
					for(int i = 0; i < d.getDocuments().size(); i++)
					{
						frame.getRemoveDocPanel().getModel().addElement(d.getDocuments().get(i).toString());
					}
				}
			}
		}
	}
}

