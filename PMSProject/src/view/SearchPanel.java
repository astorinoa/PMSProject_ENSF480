package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import control.BuyerListener;

public class SearchPanel extends JPanel {
	private JCheckBox title;
	private JCheckBox author;
	private JCheckBox type;
	private JTextField searchVal;
	private JTextArea results;
	private JButton search;
	private JButton backOnS;
	private ButtonGroup group;
	
	/**
	 * Constructs and formats the GUI components
	 * @param prof Object of type Prof that the courses are uploaded and edited by
	 * @param listener allows for the GUI compounds to be listened to as actions are performed on them
	 * @param objOut communicate over socket
	 * @param objIn communicate over socket
	 */
	public SearchPanel(BuyerListener listener)
	{
		super();
		
		this.setLayout(new BorderLayout(0, 0));

		title = new JCheckBox("Title");
		title.setFont(new Font("PingFang TC", Font.PLAIN, 15));
		title.setForeground(new Color(25, 25, 112));
		title.setBackground(new Color(176, 196, 222));
		title.setActionCommand("title");
		//title.addActionListener(listener);
		
		author = new JCheckBox("Author"); 
		author.setFont(new Font("PingFang TC", Font.PLAIN, 15));
		author.setForeground(new Color(25, 25, 112));
		author.setBackground(new Color(176, 196, 222));
		author.setActionCommand("author");
		//author.addActionListener(listener);
		
		type = new JCheckBox("Type"); 
		type.setFont(new Font("PingFang TC", Font.PLAIN, 15));
		type.setForeground(new Color(25, 25, 112));
		type.setBackground(new Color(176, 196, 222));
		type.setActionCommand("type");
		//type.addActionListener(listener);
		
		//group checkboxes
		group = new ButtonGroup();
		group.add(title);
		group.add(author);
		group.add(type);
		title.setSelected(true);

		JPanel top = new JPanel();
		top.setBackground(new Color(176, 196, 222));
		top.setLayout(new BoxLayout(top, BoxLayout.Y_AXIS));

		JPanel toSearchBy =  new JPanel();
		toSearchBy.setLayout(new BoxLayout(toSearchBy, BoxLayout.X_AXIS));
		toSearchBy.setBackground(new Color(176, 196, 222));
		JLabel searchBy = new JLabel("Search by: ");
		searchBy.setFont(new Font("PingFang TC", Font.PLAIN, 15));
		searchBy.setForeground(new Color(25, 25, 112));
		toSearchBy.add(searchBy);
		toSearchBy.add(title);
		toSearchBy.add(author);
		toSearchBy.add(type);

		JPanel toSearch = new JPanel();
		toSearch.setLayout(new BoxLayout(toSearch, BoxLayout.X_AXIS));
		toSearch.setBackground(new Color(176, 196, 222));
		toSearch.setBorder(new EmptyBorder(0, 36, 0, 50));
		JLabel searchLbl = new JLabel("Search: "); 
		searchLbl.setFont(new Font("PingFang TC", Font.PLAIN, 15));
		searchLbl.setForeground(new Color(25, 25, 112));
		searchVal = new JTextField();
		search = new JButton();
		search.setFont(new Font("PingFang TC", Font.PLAIN, 15));
		search.setForeground(new Color(25, 25, 112));
		search.setText("Search");
		search.addActionListener(listener);
		toSearch.add(searchLbl);
		toSearch.add(searchVal);
		toSearch.add(search);

		top.add(toSearchBy);
		top.add(toSearch);

		JPanel middle = new JPanel();
		middle.setLayout(new BorderLayout(0,0));
		middle.setBackground(new Color(176, 196, 222));
		middle.setBorder(new EmptyBorder(20, 40, 20, 40));
		JLabel searchResLbl = new JLabel("Search Results:");
		searchResLbl.setFont(new Font("PingFang TC", Font.PLAIN, 15));
		searchResLbl.setForeground(new Color(25, 25, 112));
		results = new JTextArea();
		results.setEditable(false);
		JScrollPane scroll = new JScrollPane(results, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		middle.add(searchResLbl, BorderLayout.NORTH);
		middle.add(scroll, BorderLayout.CENTER);

		JPanel forBack = new JPanel();
		backOnS = new JButton();
		backOnS.setText("Back");
		backOnS.setFont(new Font("PingFang TC", Font.PLAIN, 15));
		backOnS.setForeground(new Color(25, 25, 112));
		backOnS.addActionListener(listener);
		forBack.setBackground(new Color(176, 196, 222));
		forBack.setLayout(new BoxLayout(forBack, BoxLayout.X_AXIS));
		forBack.add(backOnS);

		this.add(top, BorderLayout.NORTH);
		this.add(middle, BorderLayout.CENTER);
		this.add(forBack, BorderLayout.SOUTH);

	}
	
	public JButton getSearchButton()
	{
		return search;	
	}
	
	public JButton getBackButton() {
		return backOnS;
	}
	
	/**
	 * Returns different int for each checkbox selected, 1 for title, 2 for author, 3 for type, 0 for error
	 * @return an int indicating which checkbox is selected
	 */
	public int getCheckboxSelection()
	{
		if(title.isSelected())
		{
			return 1;
		}
		else if(author.isSelected())
		{
			return 2;
		}
		else if(type.isSelected())
		{
			return 3;
		}
			
		return 0;//error no button selected
	}
	

	public JTextField getSearchText()
	{
		return searchVal;
	}
	
	public JTextArea getList()
	{
		return results;
	}
	
}
