package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import control.OperatorListener;

public class RemoveDocPanel extends JPanel {
	private DefaultListModel<String> model;
	private JList <String> documents;
	private JButton back;

	public RemoveDocPanel(OperatorListener listener) {
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
		JLabel docLbl = new JLabel("Document Inventory:");
		docLbl.setFont(new Font("PingFang TC", Font.PLAIN, 15));
		docLbl.setForeground(new Color(25, 25, 112));
		middle.add(docLbl, BorderLayout.NORTH);
		model = new DefaultListModel<>();
		documents = new JList<>(model);
		documents.addListSelectionListener(listener);
		JScrollPane scroll = new JScrollPane(documents, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		middle.add(scroll, BorderLayout.CENTER);

		// need to fill documents jlist with documents 
		//try {
	

		//	prof.setCourses((ArrayList<Course>) objIn.readObject());
		//	for(int i = 0; i < prof.getCourses().size(); i++)
		//	{
		//		model.addElement(prof.getCourses().get(i).toString());
		//	}
		//} catch (IOException e) {
		//	e.printStackTrace();
		//} catch(ClassNotFoundException e)
		//{
		//	System.err.println(e.getMessage());
		//}
		
		JPanel bottom = new JPanel();
		bottom.setBackground(new Color(176, 196, 222));
		bottom.setLayout(new BoxLayout(bottom, BoxLayout.X_AXIS));
		bottom.setBorder(new EmptyBorder(0, 20, 10, 80));
		
		JLabel warning = new JLabel("	The document you click will be removed");
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
}
