package view;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.BuyerListener;
import control.OperatorListener;

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
	
	//register page
	private RegPanel regPanel;
	
	//make payment page
	
	//promotions page
	private PromoPanel promoPanel;
	
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
		
		//create registered home panel
		regHomePanel = new RegisteredHomePanel(listener);
		contentPane.add(regHomePanel, "Registered Home");
		
		//create ordinary home panel
		ordHomePanel = new OrdinaryHomePanel(listener);
		contentPane.add(ordHomePanel, "Ordinary Home");
		
		//create search panel
		searchPanel = new SearchPanel(listener);
		searchPanel.add(searchPanel, "Search");
		
		//create promo panel
		promoPanel = new PromoPanel(listener);
		promoPanel.add(promoPanel, "Promotion");
		
		//create reg panel
		regPanel = new RegPanel(listener);
		regPanel.add(regPanel, "Registration");
		
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
	
	public CardLayout getCardLayout()
	{
		return cardLayout;
	}
}