package view;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.border.MatteBorder;

import control.LoginListener;

import javax.swing.border.CompoundBorder;

/**
 * Creates a panel for user login
 * @author Alexa Astorino, Shreya Patel, Rae McPhail
 *
 */
public class LoginForm extends JFrame {

	private JTextField userEmail;
	private JPasswordField passwordField;
	private JButton login;
	private JButton guest;
	private LoginListener listener;

	/**
	 * Create the frame.
	 * @param objOut to communicate over socket
	 * @param objIn to communicate over socket
	 */
	public LoginForm() {
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		listener = new LoginListener(this);
		
		setBounds(100, 100, 450, 300);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 196, 222));
		contentPane.setBorder(new EmptyBorder(10, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblLoginToPMS = new JLabel("Publication Management System");
		lblLoginToPMS.setForeground(new Color(25, 25, 112));
		lblLoginToPMS.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginToPMS.setFont(new Font("PingFang TC", Font.PLAIN, 38));
		contentPane.add(lblLoginToPMS, BorderLayout.NORTH);
		
		JPanel forGuestButton = new JPanel();
		forGuestButton.setBackground(new Color(176, 196, 222));
		forGuestButton.setLayout(new FlowLayout());
		forGuestButton.setBorder(new EmptyBorder(0, 20, 30, 20));
		guest = new JButton();
		guest.setForeground(new Color(25, 25, 112));
		guest.setFont(new Font("PingFang TC", Font.PLAIN, 20));
		guest.setText("Continue as Guest Buyer");
		guest.addActionListener(listener);
		forGuestButton.add(guest);
		contentPane.add(forGuestButton, BorderLayout.SOUTH);
		
		JPanel loginInfo = new JPanel ();
		loginInfo.setBackground(new Color(176, 196, 222));
		loginInfo.setLayout(new BoxLayout(loginInfo, BoxLayout.PAGE_AXIS));
		loginInfo.setBorder(new CompoundBorder(new EmptyBorder(20, 20, 40, 20), new MatteBorder(2, 2, 2, 2, (Color) new Color(25, 25, 112))));
		
		JLabel loginLabel = new JLabel("Login");
		loginLabel.setForeground(new Color(25, 25, 112));
		loginLabel.setFont(new Font("PingFang TC", Font.PLAIN, 25));
		
		JPanel one = new JPanel ();
		one.setBackground(new Color(176, 196, 222));
		one.setLayout(new FlowLayout());
		one.setBorder(new EmptyBorder(20, 0, 0, 0));
		JLabel userLabel = new JLabel("   Email:");
		userLabel.setForeground(new Color(25, 25, 112));
		userLabel.setFont(new Font("PingFang TC", Font.PLAIN, 20));
		one.add(userLabel);
		userEmail = new JTextField(15);
		userEmail.setName("userEmail");
		one.add(userEmail);
		
		JPanel two = new JPanel ();
		two.setBackground(new Color(176, 196, 222));
		two.setLayout(new FlowLayout());
		two.setBorder(new EmptyBorder(0, 20, 20, 20));
		JLabel passLabel = new JLabel("Password:");
		passLabel.setForeground(new Color(25, 25, 112));
		passLabel.setFont(new Font("PingFang TC", Font.PLAIN, 20));
		two.add(passLabel);
		
		passwordField = new JPasswordField(15);
		passwordField.setSize(2, 15);
		two.add(passwordField);
		
		JPanel forButton = new JPanel();
		forButton.setBackground(new Color(176, 196, 222));
		forButton.setLayout(new FlowLayout());
		forButton.setBorder(new EmptyBorder(0, 20, 30, 20));
		login = new JButton();
		login.setForeground(new Color(25, 25, 112));
		login.setFont(new Font("PingFang TC", Font.PLAIN, 20));
		login.setText("Login");
		login.addActionListener(listener);
		forButton.add(login);
		
		loginInfo.add(loginLabel);
		loginInfo.add(one);
		loginInfo.add(two);
		loginInfo.add(forButton);
		contentPane.add(loginInfo, BorderLayout.CENTER);
		this.pack();
		this.setVisible(true);
	}


	/**
	 * @return the login
	 */
	public JButton getLogin() {
		return login;
	}	
	
	/**
	 * @return the guest
	 */
	public JButton getGuest() {
		return guest;
	}
	
	/**
	 * @return the userEmail
	 */
	public JTextField getuserEmail() {
		return userEmail;
	}
	
	/**
	 * @return the passwordField
	 */
	public JPasswordField getPasswordField() {
		return passwordField;
	}
	
	
}
