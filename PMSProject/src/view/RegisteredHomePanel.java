package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.text.SimpleDateFormat;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.BuyerListener;

/**
 * Creates a JPanel where registered buyers can select the option to search documents, place an order,
 * view promotions or unsubscribe
 * @author Alexa Astorino, Shreya Patel, Rae McPhail
 *
 */
public class RegisteredHomePanel extends JPanel{
	private JButton logout;
	private JButton search;
	private JButton placeOrder;
	private JButton viewPromotions;
	private JButton unsubscribe;
	
	/**
	 * Creates and sets java swing GUI components, adding listeners to JButtons
	 * @param listener of type BuyerListener for implementing functionality
	 */
	public RegisteredHomePanel(BuyerListener listener) {
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
		middle.setLayout(new BoxLayout(middle, BoxLayout.Y_AXIS));
		middle.setBorder(new EmptyBorder(40, 100, 0, 100));
			
		search = new JButton();
		search.setFont(new Font("PingFang TC", Font.PLAIN, 15));
		search.setForeground(new Color(25, 25, 112));
		search.setAlignmentX(Component.CENTER_ALIGNMENT);
		search.setText("Search");
		search.addActionListener(listener);
	
		placeOrder = new JButton();
		placeOrder.setFont(new Font("PingFang TC", Font.PLAIN, 15));
		placeOrder.setForeground(new Color(25, 25, 112));
		placeOrder.setAlignmentX(Component.CENTER_ALIGNMENT);
		placeOrder.setHorizontalAlignment(SwingConstants.LEFT);
		placeOrder.setText("Place Order");
		placeOrder.addActionListener(listener);
		
		viewPromotions = new JButton();
		viewPromotions.setFont(new Font("PingFang TC", Font.PLAIN, 15));
		viewPromotions.setForeground(new Color(25, 25, 112));
		viewPromotions.setAlignmentX(Component.CENTER_ALIGNMENT);
		viewPromotions.setText("View Promotions");
		viewPromotions.addActionListener(listener);
		
		unsubscribe = new JButton();
		unsubscribe.setFont(new Font("PingFang TC", Font.PLAIN, 15));
		unsubscribe.setForeground(new Color(25, 25, 112));
		unsubscribe.setAlignmentX(Component.CENTER_ALIGNMENT);
		unsubscribe.setText("Unsubscribe");
		unsubscribe.addActionListener(listener);
		
		middle.add(search);
		middle.add(placeOrder);
		middle.add(viewPromotions);
		middle.add(unsubscribe);
		
		JPanel bottom = new JPanel();
		bottom.setBackground(new Color(176, 196, 222));
		bottom.setLayout(new BoxLayout(bottom, BoxLayout.X_AXIS));
		bottom.setBorder(new EmptyBorder(0, 20, 10, 80));
		
		logout = new JButton();
		logout.setForeground(new Color(25, 25, 112));
		logout.setFont(new Font("PingFang TC", Font.PLAIN, 15));
		logout.setAlignmentX(Component.CENTER_ALIGNMENT);
		logout.setText("Logout");
		logout.addActionListener(listener);
		
		bottom.add(logout);
		
		this.add(top, BorderLayout.NORTH);
		this.add(middle, BorderLayout.CENTER);
		this.add(bottom, BorderLayout.SOUTH);
	}	
	
	public JButton getLogout()
	{
		return logout;
	}

	public JButton getSearch() {
		return search;
	}

	public JButton getPlaceOrder() {
		return placeOrder;
	}

	public JButton getViewPromotions() {
		return viewPromotions;
	}

	public JButton getUnsubscribe() {
		return unsubscribe;
	}

}
