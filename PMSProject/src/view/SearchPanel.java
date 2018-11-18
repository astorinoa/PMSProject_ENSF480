package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
	private JButton clear;
	
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
		title.addActionListener(listener);
		author = new JCheckBox("Author"); 
		author.setFont(new Font("PingFang TC", Font.PLAIN, 15));
		author.setForeground(new Color(25, 25, 112));
		author.setBackground(new Color(176, 196, 222));
		author.addActionListener(listener);
		type = new JCheckBox("Type"); 
		type.setFont(new Font("PingFang TC", Font.PLAIN, 15));
		type.setForeground(new Color(25, 25, 112));
		type.setBackground(new Color(176, 196, 222));
		type.addActionListener(listener);

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
		middle.add(searchResLbl, BorderLayout.NORTH);
		middle.add(results, BorderLayout.CENTER);

		JPanel forBack = new JPanel();
		backOnS = new JButton();
		backOnS.setText("Back");
		backOnS.setFont(new Font("PingFang TC", Font.PLAIN, 15));
		backOnS.setForeground(new Color(25, 25, 112));
		backOnS.addActionListener(listener);
		clear = new JButton();
		clear.setText("Clear Search Results");
		clear.setFont(new Font("PingFang TC", Font.PLAIN, 15));
		clear.setForeground(new Color(25, 25, 112));
		clear.addActionListener(listener);
		forBack.setBackground(new Color(176, 196, 222));
		forBack.setLayout(new BoxLayout(forBack, BoxLayout.X_AXIS));
		forBack.add(backOnS);
		forBack.add(clear);

		this.add(top, BorderLayout.NORTH);
		this.add(middle, BorderLayout.CENTER);
		this.add(forBack, BorderLayout.SOUTH);

	}
}