package view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.BuyerListener;

public class BuyerAccountForm extends JFrame {

	private BuyerListener listener;
	private JPanel contentPane;
	private CardLayout cardLayout;
	
	//registered buyer home page
	private RegisteredHomePanel regHomePanel;
	
	//ordinary buyer home page
	private OrdinaryHomePanel ordHomePanel;
	
	//search page
	private SearchPanel searchPanel;
	
	//place order page
	private PlaceOrderPanel orderPanel;
	
	//register page
	private RegPanel regPanel;
	
	//make payment page
	private PaymentPanel payPanel;
	
	//promotions page
	private PromoPanel promoPanel;
	
	//the registered buyers email
	private String email;
	
	public BuyerAccountForm(int buyerType) {
		listener = new BuyerListener(this, buyerType);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setPreferredSize( new Dimension(550,350));
		cardLayout = new CardLayout();
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 196, 222));
		contentPane.setBorder(new EmptyBorder(2, 3, 2, 3));
		contentPane.setLayout(cardLayout);
		this.setContentPane(contentPane);
		
		//create registered home panel
		regHomePanel = new RegisteredHomePanel(listener);
		contentPane.add(regHomePanel, "Registered Home");
		
		//create ordinary home panel
		ordHomePanel = new OrdinaryHomePanel(listener);
		contentPane.add(ordHomePanel, "Ordinary Home");
		
		//create search panel
		searchPanel = new SearchPanel(listener);
		contentPane.add(searchPanel, "Search");
		
		//create promo panel
		promoPanel = new PromoPanel(listener);
		contentPane.add(promoPanel, "Promotion");
		
		//create reg panel
		regPanel = new RegPanel(listener);
		contentPane.add(regPanel, "Registration");
		
		//create order panel
		orderPanel = new PlaceOrderPanel(listener);
		contentPane.add(orderPanel, "Order");
		
		//create payment panel
		payPanel = new PaymentPanel(listener);
		contentPane.add(payPanel, "Payment");
		
		this.pack();
		this.setVisible(true);
	}

	public RegisteredHomePanel getRegHomePanel() {
		return regHomePanel;
	}

	public OrdinaryHomePanel getOrdHomePanel() {
		return ordHomePanel;
	}

	public SearchPanel getSearchPanel() {
		return searchPanel;
	}

	public RegPanel getRegPanel() {
		return regPanel;
	}

	public PromoPanel getPromoPanel() {
		return promoPanel;
	}
	
	public PlaceOrderPanel getOrderPanel()
	{
		return orderPanel;
	}
	
	public CardLayout getCardLayout()
	{
		return cardLayout;
	}
	
	public void  setEmail(String s)
	{
		email = s;
		listener.setEmail(email);
	}
}