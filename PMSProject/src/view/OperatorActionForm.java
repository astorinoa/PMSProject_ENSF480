package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import control.OperatorListener;

import java.awt.*;

/**
 * Creates a JFrame for an operator that implements card layout to switch between other JPanels
 * @author Alexa Astorino, Shreya Patel, Rae McPhail
 *
 */
public class OperatorActionForm extends JFrame {

	private OperatorListener listener;
	private JPanel contentPane;
	private CardLayout cardLayout;
	
	// home page
	private OperatorHomePanel homePanel;
	
	// add doc page
	private AddDocPanel addDocPanel;
	
	// update doc page
	private UpdateDocPanel updateDocPanel;
	
	// doc info panel
	private DocInfoPanel docInfoPanel;
	
	// remove doc page
	private RemoveDocPanel removeDocPanel;
	
	/**
	 * Create the Operator Action frame by setting java swing GUI components and creates multiple JPanels
	 */
	public OperatorActionForm() {
		listener = new OperatorListener(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setPreferredSize( new Dimension(550,350));
		cardLayout = new CardLayout();
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 196, 222));
		contentPane.setBorder(new EmptyBorder(2, 3, 2, 3));
		contentPane.setLayout(cardLayout);
		this.setContentPane(contentPane);	
		
		//create operator home panel
		homePanel = new OperatorHomePanel(listener);
		contentPane.add(homePanel, "Home");
		
		//create add document panel
		addDocPanel = new AddDocPanel(listener);
		contentPane.add(addDocPanel, "Add Documents");
		
		//create update document panel
		updateDocPanel = new UpdateDocPanel(listener);
		contentPane.add(updateDocPanel, "Update Documents");
		
		//create remove document panel
		removeDocPanel = new RemoveDocPanel(listener);
		contentPane.add(removeDocPanel, "Remove Documents");
		
		//create document info panel
		docInfoPanel = new DocInfoPanel(listener);
		contentPane.add(docInfoPanel, "Document Information");
		
		
		this.pack();
		this.setVisible(true);
	}
	
	public OperatorHomePanel getOperatorHomePanel()
	{
		return homePanel;
	}
	
	public AddDocPanel getAddDocPanel()
	{
		return addDocPanel;
	}
	
	public UpdateDocPanel getUpdateDocPanel()
	{
		return updateDocPanel;
	}
	
	public RemoveDocPanel getRemoveDocPanel()
	{
		return removeDocPanel;
	}
	
	public DocInfoPanel getDocInfoPanel()
	{
		return docInfoPanel;
	}
	
	public CardLayout getCardLayout()
	{
		return cardLayout;
	}
	 
	 
}	
	
	