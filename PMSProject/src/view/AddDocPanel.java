package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.text.SimpleDateFormat;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import control.EditDocumentController;
import control.OperatorListener;

/**
 * Creates a JPanel where operators can see a JList of documents pending approval & approve them to
 * be added to the document inventory
 * Please note: due to partial implementation, approval queue consists of documents rather than author submissions
 * @author Alexa Astorino, Shreya Patel, Rae McPhail
 *
 */
public class AddDocPanel extends JPanel {
	private DefaultListModel<String> model;
	private JList <String> approvalQueue;
	private JButton back;

	/**
	 * Creates and sets java swing GUI components, adding listeners to JButtons or JList features
	 * @param listener of type OperatorListener for implementing functionality
	 */
	public AddDocPanel(OperatorListener listener) {
		super();
		
		this.setBackground(new Color(176, 196, 222));
		this.setLayout(new BorderLayout(0, 0));
		
		JPanel top =  new JPanel();
		top.setBackground(new Color(176, 196, 222));
		top.setLayout(new BorderLayout(0, 0));		
		java.util.Date theDate = new java.util.Date();
		SimpleDateFormat dFormat = new SimpleDateFormat("EEEE, MMMM d, yyyy");
		JLabel date = new JLabel("" + dFormat.format(theDate));
		date.setFont(new Font("PingFang TC", Font.PLAIN, 14));
		date.setForeground(new Color(25, 25, 112));
		top.add(date, BorderLayout.WEST);
		
		JPanel middle = new JPanel();
		middle.setBackground(new Color(176, 196, 222));
		middle.setLayout(new BorderLayout(0, 0));
		middle.setBorder(new EmptyBorder(25, 25, 25, 25));
		JLabel docLbl = new JLabel("Documents Pending Approval:");
		docLbl.setFont(new Font("PingFang TC", Font.PLAIN, 15));
		docLbl.setForeground(new Color(25, 25, 112));
		middle.add(docLbl, BorderLayout.NORTH);
		model = new DefaultListModel<>();
		approvalQueue = new JList<>(model);
		approvalQueue.addListSelectionListener(listener);
		JScrollPane scroll = new JScrollPane(approvalQueue, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		middle.add(scroll, BorderLayout.CENTER);

		EditDocumentController d = new EditDocumentController();
		for(int i = 0; i < d.getApprovalDocuments().size(); i++)
		{
			model.addElement(d.getApprovalDocuments().get(i).toString());
		}
		
		JPanel bottom = new JPanel();
		bottom.setBackground(new Color(176, 196, 222));
		bottom.setLayout(new BoxLayout(bottom, BoxLayout.X_AXIS));
		bottom.setBorder(new EmptyBorder(0, 20, 10, 80));
		
		JLabel warning = new JLabel("	The document you click will be approved");
		warning.setFont(new Font("PingFang TC", Font.PLAIN, 15));
		warning.setForeground(new Color(25, 25, 112));
		
		back = new JButton();
		back.setForeground(new Color(25, 25, 112));
		back.setFont(new Font("PingFang TC", Font.PLAIN, 15));
		back.setAlignmentX(Component.CENTER_ALIGNMENT);
		back.setText("Back");
		back.addActionListener(listener);
		
		bottom.add(back);
		bottom.add(warning);
		
		this.add(top, BorderLayout.NORTH);
		this.add(middle, BorderLayout.CENTER);
		this.add(bottom, BorderLayout.SOUTH);
	}	
	
	public JButton getBack()
	{
		return back;
	}
	
	public JList<String> getDocuments()
	{
		return approvalQueue;
	}
	public DefaultListModel<String> getModel(){
		return model;
	}
}
