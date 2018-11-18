package view;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.OperatorListener;

public class BuyerAccountForm extends JFrame {

	private BuyerListener listener;
	private JPanel contentPane;
	private CardLayout cardLayout;
	
	//registered buyer home page
	
	
	//ordinary buyer home page
	
	//search page
	
	//search results page
	
	//place order page
	
	//register page
	
	//unsubscribe page
	
	//make payment page
	
	//promotions page
	
	public BuyerAccountForm() {
		listener = new BuyerListener(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		cardLayout = new CardLayout();
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 196, 222));
		contentPane.setBorder(new EmptyBorder(2, 3, 2, 3));
		contentPane.setLayout(cardLayout);
		this.setContentPane(contentPane);	
	}
}