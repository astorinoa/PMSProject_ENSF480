package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Label;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import control.OperatorListener;

public class DocInfoPanel extends JPanel{
	private JTextArea title;
	private JTextArea author;
	private JTextArea price;
	private JTextArea address;
	private JTextArea quantity;
	private JButton update;
	private JButton back;

	public DocInfoPanel(OperatorListener listener) {
		super();
		
		this.setLayout(new BorderLayout(0, 0));
		
		JPanel middle = new JPanel ();
		middle.setLayout(new BoxLayout(middle, BoxLayout.Y_AXIS));
		middle.setBackground(new Color(176, 196, 222));
		middle.setBorder(new EmptyBorder(20, 20, 20, 20));
		JLabel info = new JLabel("Document Information:");
		info.setFont(new Font("PingFang TC", Font.PLAIN, 20));
		info.setForeground(new Color(25, 25, 112));
		middle.add(info);

		JPanel one = new JPanel ();
		one.setLayout(new FlowLayout());
		one.setBackground(new Color(176, 196, 222));
		JPanel two = new JPanel ();
		two.setLayout(new FlowLayout());
		two.setBackground(new Color(176, 196, 222));
		JPanel three = new JPanel ();
		three.setLayout(new FlowLayout());
		three.setBackground(new Color(176, 196, 222));
		JPanel four = new JPanel ();
		four.setLayout(new FlowLayout());
		four.setBackground(new Color(176, 196, 222));

		JLabel forTitle = new JLabel("Title: ");
		forTitle.setForeground(new Color(25, 25, 112));
		forTitle.setFont(new Font("PingFang TC", Font.PLAIN, 20));
		one.add(forTitle);
		title = new JTextArea(1,20);
		one.add(title);

		JLabel forAuthor = new JLabel("Author: ");
		forAuthor.setForeground(new Color(25, 25, 112));
		forAuthor.setFont(new Font("PingFang TC", Font.PLAIN, 20));
		two.add(forAuthor);
		author = (new JTextArea(1,18));
		two.add(author);

		JLabel forPrice = new JLabel("Price $: ");
		forPrice.setForeground(new Color(25, 25, 112));
		forPrice.setFont(new Font("PingFang TC", Font.PLAIN, 20));
		three.add(forPrice);
		price = (new JTextArea(1,10));
		three.add(price);

		JLabel forQuantity = new JLabel("Quantity: ");
		forQuantity.setForeground(new Color(25, 25, 112));
		forQuantity.setFont(new Font("PingFang TC", Font.PLAIN, 20));
		four.add(forQuantity);
		quantity = (new JTextArea(1,5));
		four.add(quantity);
		
		middle.add(one);
		middle.add(two);
		middle.add(three);
		middle.add(four);

		JPanel forButton = new JPanel();
		back = new JButton();
		back.setText("Back");
		back.setFont(new Font("PingFang TC", Font.PLAIN, 15));
		back.setForeground(new Color(25, 25, 112));
		back.addActionListener(listener);
		update = new JButton();
		update.setText("Update");
		update.setFont(new Font("PingFang TC", Font.PLAIN, 15));
		update.setForeground(new Color(25, 25, 112));
		update.addActionListener(listener);
		forButton.setBackground(new Color(176, 196, 222));
		forButton.setLayout(new BoxLayout(forButton, BoxLayout.X_AXIS));
		forButton.add(back);
		forButton.add(update);
		
		this.add(middle, BorderLayout.CENTER);
		this.add(forButton, BorderLayout.SOUTH);
		
	}
}
