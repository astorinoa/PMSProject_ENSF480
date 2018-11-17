package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.text.SimpleDateFormat;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import control.Operator;
import control.OperatorListener;

public class OperatorHomePanel extends JPanel{
	private JButton logout;
	private JButton add;
	private JButton update;
	private JButton remove;
	
	public OperatorHomePanel(Operator op, OperatorListener listener) {
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
		JLabel opEmail = new JLabel("Loggin in as: " + op.getEmail())	;	
		opEmail.setFont(new Font("PingFang TC", Font.PLAIN, 14));
		opEmail.setForeground(new Color(25, 25, 112));
		top.add(date, BorderLayout.WEST);
		top.add(opEmail, BorderLayout.EAST);

		JPanel middle = new JPanel();
		middle.setBackground(new Color(176, 196, 222));
		middle.setLayout(new BoxLayout(middle, BoxLayout.Y_AXIS));
		middle.setBorder(new EmptyBorder(40, 100, 0, 100));
			
		add = new JButton();
		add.setFont(new Font("PingFang TC", Font.PLAIN, 15));
		add.setForeground(new Color(25, 25, 112));
		add.setAlignmentX(Component.CENTER_ALIGNMENT);
		add.setText("Add Documents");
		add.addActionListener(listener);
	
		update = new JButton();
		update.setFont(new Font("PingFang TC", Font.PLAIN, 15));
		update.setForeground(new Color(25, 25, 112));
		update.setAlignmentX(Component.CENTER_ALIGNMENT);
		update.setHorizontalAlignment(SwingConstants.LEFT);
		update.setText("Update Documents");
		update.addActionListener(listener);
		
		remove = new JButton();
		remove.setFont(new Font("PingFang TC", Font.PLAIN, 15));
		remove.setForeground(new Color(25, 25, 112));
		remove.setAlignmentX(Component.CENTER_ALIGNMENT);
		remove.setText("Remove Documents");
		remove.addActionListener(listener);
		
		middle.add(add);
		middle.add(update);
		middle.add(remove);
		
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
	
	public JButton getAdd()
	{
		return add;
	}
	
	public JButton getUpdate()
	{
		return update;
	}
	
	public JButton getRemove()
	{
		return remove;
	}
	
}
