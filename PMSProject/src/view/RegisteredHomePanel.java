package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

import control.OperatorListener;

public class RegisteredHomePanel extends JPanel{
	private JButton logout;
	private JButton search;
	private JButton placeOrder;
	private JButton viewPromotions;
	private JButton unsubcribe;
	
	public RegisteredHomePanel(BuyerListener listener) {
		super();
		
		this.setBackground(new Color(176, 196, 222));
		this.setLayout(new BorderLayout(0, 0));
	}	
	
}
