package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import control.BuyerListener;

public class RegPanel extends JPanel{
	private JTextField fName;
	private JTextField lName;
	private JTextField email;
	private JPasswordField passwordField;
	private JButton register;
	private JButton back;

	public RegPanel(BuyerListener listener) {
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
		
		JPanel regInfo = new JPanel ();
		regInfo.setBackground(new Color(176, 196, 222));
		regInfo.setLayout(new BoxLayout(regInfo, BoxLayout.PAGE_AXIS));
		regInfo.setBorder(new EmptyBorder(25, 25, 25, 25));
		
		JPanel one = new JPanel ();
		one.setBackground(new Color(176, 196, 222));
		one.setLayout(new FlowLayout());
		one.setBorder(new EmptyBorder(0, 0, 0, 0));
		JLabel fLabel = new JLabel("First Name:");
		fLabel.setForeground(new Color(25, 25, 112));
		fLabel.setFont(new Font("PingFang TC", Font.PLAIN, 20));
		one.add(fLabel);
		fName = new JTextField(10);
		fName.setName("first name");
		one.add(fName);
		
		JPanel two = new JPanel ();
		two.setBackground(new Color(176, 196, 222));
		two.setLayout(new FlowLayout());
		two.setBorder(new EmptyBorder(0, 0, 0, 0));
		JLabel lLabel = new JLabel("Last Name:");
		lLabel.setForeground(new Color(25, 25, 112));
		lLabel.setFont(new Font("PingFang TC", Font.PLAIN, 20));
		two.add(lLabel);
		lName = new JTextField(10);
		lName.setName("last name");
		two.add(lName);
		
		JPanel three = new JPanel ();
		three.setBackground(new Color(176, 196, 222));
		three.setLayout(new FlowLayout());
		three.setBorder(new EmptyBorder(0, 0, 0, 0));
		JLabel eLabel = new JLabel("Email:");
		eLabel.setForeground(new Color(25, 25, 112));
		eLabel.setFont(new Font("PingFang TC", Font.PLAIN, 20));
		three.add(eLabel);
		email = new JTextField(10);
		email.setName("email");
		three.add(email);
		
		JPanel four = new JPanel ();
		four.setBackground(new Color(176, 196, 222));
		four.setLayout(new FlowLayout());
		four.setBorder(new EmptyBorder(0, 0, 0, 0));
		JLabel passLabel = new JLabel("Password:");
		passLabel.setForeground(new Color(25, 25, 112));
		passLabel.setFont(new Font("PingFang TC", Font.PLAIN, 20));
		four.add(passLabel);
		passwordField = new JPasswordField(15);
		passwordField.setSize(2, 15);
		four.add(passwordField);
		
		JPanel forButton = new JPanel();
		forButton.setBackground(new Color(176, 196, 222));
		forButton.setLayout(new FlowLayout());
		forButton.setBorder(new EmptyBorder(0, 20, 30, 20));
		register = new JButton();
		register.setForeground(new Color(25, 25, 112));
		register.setFont(new Font("PingFang TC", Font.PLAIN, 15));
		register.setText("Register");
		register.addActionListener(listener);
		forButton.add(register);
		back = new JButton();
		back.setForeground(new Color(25, 25, 112));
		back.setFont(new Font("PingFang TC", Font.PLAIN, 15));
		back.setAlignmentX(Component.CENTER_ALIGNMENT);
		back.setText("Back");
		back.addActionListener(listener);
		forButton.add(back);
		
		regInfo.add(one);
		regInfo.add(two);
		regInfo.add(three);
		regInfo.add(four);
		//regInfo.add(forButton);
		this.add(top, BorderLayout.NORTH);
		this.add(regInfo, BorderLayout.CENTER);
		this.add(forButton, BorderLayout.SOUTH);
	}
	
	public JButton getBack()
	{
		return back;
	}
	
	public JButton getRegister()
	{
		return register;
	}
	
	public JTextField getfName() {
		return fName;
	}

	public JTextField getlName() {
		return lName;
	}

	public JTextField getEmail() {
		return email;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}
}
