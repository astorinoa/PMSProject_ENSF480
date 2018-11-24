package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import control.BuyerListener;

public class PaymentPanel extends JPanel {
	private JTextField total;
	private JButton confirmPay;
	private JButton back;
	
	public PaymentPanel(BuyerListener listener) {
		super();
		
		this.setBackground(new Color(176, 196, 222));
		this.setLayout(new BorderLayout(0, 0));
		
		JPanel one = new JPanel ();
		one.setBackground(new Color(176, 196, 222));
		one.setLayout(new FlowLayout());
		one.setBorder(new EmptyBorder(100, 0, 0, 0));
		JLabel totLabel = new JLabel("Total:");
		totLabel.setForeground(new Color(25, 25, 112));
		totLabel.setFont(new Font("PingFang TC", Font.PLAIN, 20));
		one.add(totLabel);
		total = new JTextField(10);
		total.setName("first name");
		total.setEditable(false);
		one.add(total);

		JPanel forButton = new JPanel();
		forButton.setBackground(new Color(176, 196, 222));
		forButton.setLayout(new FlowLayout());
		forButton.setBorder(new EmptyBorder(0, 20, 30, 20));
		confirmPay = new JButton();
		confirmPay.setForeground(new Color(25, 25, 112));
		confirmPay.setFont(new Font("PingFang TC", Font.PLAIN, 15));
		confirmPay.setText("Make Payment");
		confirmPay.addActionListener(listener);
		forButton.add(confirmPay);
		back = new JButton();
		back.setForeground(new Color(25, 25, 112));
		back.setFont(new Font("PingFang TC", Font.PLAIN, 15));
		back.setAlignmentX(Component.CENTER_ALIGNMENT);
		back.setText("Back");
		back.addActionListener(listener);
		forButton.add(back);
		
		this.add(one, BorderLayout.CENTER);
		this.add(forButton, BorderLayout.SOUTH);
	}
	
	public JButton getBack() {
		return back;
	}
	
	public JButton getConfirm() {
		return confirmPay;
	}
	
	public void setPrice (int p) {
		total.setText(String.valueOf(p));
	}
}
