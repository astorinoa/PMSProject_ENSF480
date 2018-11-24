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
	private EditDocumentController d; 
	private int tempId;
	private String tempType;
	
	/**
	 * Constructor for the listener
	 * @param jf the frame that the listener connects to
	 */
	public OperatorListener(OperatorActionForm jf) {
		frame = jf;
		d = new EditDocumentController();
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
		
		//if back button on document info panel pressed
		else if(a.getSource() == frame.getDocInfoPanel().getBack()) {
			//show the home panel
			frame.getCardLayout().show(frame.getContentPane(), "Update Documents");
		}
		
		//if update button on document info panel pressed
		else if(a.getSource() == frame.getDocInfoPanel().getUpdate()) {
			//update database	
			Document toUpdate = new Document(tempId, tempType, frame.getDocInfoPanel().getAuthor().getText(), 
						frame.getDocInfoPanel().getTitle().getText(), Integer.parseInt(frame.getDocInfoPanel().getPrice().getText()), 
						Integer.parseInt(frame.getDocInfoPanel().getQuantity().getText()));
			d.updateDocument(toUpdate);
			frame.getUpdateDocPanel().getModel().removeAllElements();
			for(int i = 0; i < d.getDocuments().size(); i++)
			{
				frame.getUpdateDocPanel().getModel().addElement(d.getDocuments().get(i).toString());
			}
			
		}
	}	
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (e.getValueIsAdjusting()) {
			
			// remove document
			if (e.getSource() == frame.getRemoveDocPanel().getDocuments()) {
				if(frame.getRemoveDocPanel().getDocuments().getSelectedIndex() != -1)
				{
					Document doomed = d.getDocuments().get(frame.getRemoveDocPanel().getDocuments().getSelectedIndex());
					d.deleteDocument(doomed);
					
					//remove deleted document from remove doc panel
					frame.getRemoveDocPanel().getModel().removeAllElements();	
					for(int i = 0; i < d.getDocuments().size(); i++)
					{
						frame.getRemoveDocPanel().getModel().addElement(d.getDocuments().get(i).toString());
					}
					
					//remove deleted document from update doc panel
					frame.getUpdateDocPanel().getModel().removeAllElements();
					for(int i = 0; i < d.getDocuments().size(); i++)
					{
						frame.getUpdateDocPanel().getModel().addElement(d.getDocuments().get(i).toString());
					}
				}
			}
			
			// add document from the approval queue
			if (e.getSource() == frame.getAddDocPanel().getDocuments()) {
				if(frame.getAddDocPanel().getDocuments().getSelectedIndex() != -1)
				{
					ApprovalDocument add = d.getApprovalDocuments().get(frame.getAddDocPanel().getDocuments().getSelectedIndex());
					//add to inventory
					d.addDocument(add);
					//delete from approval queue
					d.deleteDocument(add);
					
					frame.getAddDocPanel().getModel().removeAllElements();
					for(int i = 0; i < d.getApprovalDocuments().size(); i++)
					{
						frame.getAddDocPanel().getModel().addElement(d.getApprovalDocuments().get(i).toString());
					}
					
					//fill newly approved documents into remove document panel
					frame.getRemoveDocPanel().getModel().removeAllElements();
					for(int i = 0; i < d.getDocuments().size(); i++)
					{
						frame.getRemoveDocPanel().getModel().addElement(d.getDocuments().get(i).toString());
					}
					
					//fill newly approved documents into update document panel
					frame.getUpdateDocPanel().getModel().removeAllElements();
					for(int i = 0; i < d.getDocuments().size(); i++)
					{
						frame.getUpdateDocPanel().getModel().addElement(d.getDocuments().get(i).toString());
					}
				}
			}
			if (e.getSource() == frame.getUpdateDocPanel().getDocuments()) {
				if(frame.getUpdateDocPanel().getDocuments().getSelectedIndex() != -1)
				{
					String selected = frame.getUpdateDocPanel().getDocuments().getSelectedValue();
					addInfo(selected);
					frame.getCardLayout().show(frame.getContentPane(), "Document Information");
					
				}
				
			}
		}
	}
	
	public void addInfo(String info) {
		int findId = info.indexOf(" ");
		tempId = Integer.parseInt(info.substring(0,(findId)));
		int findType = info.indexOf("type: ");
		int findEndType = info.indexOf(" - quantity avaliable: ");
		tempType = info.substring((findType+6),(findEndType));
		Document doc = d.getDocumentByID(tempId);
		frame.getDocInfoPanel().getTitle().setText(doc.getTitle());
		frame.getDocInfoPanel().getAuthor().setText(doc.getAuthor());
		frame.getDocInfoPanel().getPrice().setText(Integer.toString(doc.getPrice()));
		frame.getDocInfoPanel().getQuantity().setText(Integer.toString(doc.getQuantity()));
	}
	
}

