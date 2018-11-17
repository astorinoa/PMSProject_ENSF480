package view;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import control.OperatorListener;

import java.awt.*;

/**
 * Creates a JPanel for an operator that switches between other JPanels
 * @author Rae McPhail, Alexa Astorino, Shreya Patel
 *
 */
public class OperatorWindow extends JFrame {

	private OperatorListener listener;
	private JPanel contentPane;
	private CardLayout cardLayout;
	
	// home page
	private OperatorHomePanel homePanel;
	
	// add doc page
	private AddDocPanel addDocPanel;
	
	// update doc page
	private UpdateDocPanel updateDocPanel;
	
	// remove doc page
	private RemoveDocPanel removeDocPanel;
	
	public OperatorWindow() {
		listener = new OperatorListener(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		cardLayout = new CardLayout();
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 196, 222));
		contentPane.setBorder(new EmptyBorder(2, 3, 2, 3));
		contentPane.setLayout(cardLayout);
		this.setContentPane(contentPane);	
		
		//create operator home panel
		homePanel = new OperatorHomePanel(listener);
		contentPane.add(homePanel, "Home");
	}
	
	public OperatorHomePanel getOperatorHomePanel()
	{
		return homePanel;
	}
	
	public AddDocPanel getAddDocPanel()
	{
		return addDocPanel;
	}
	
	public UpdateDocPanel getUpdateDocPanel()
	{
		return updateDocPanel;
	}
	
	public RemoveDocPanel getRemoveDocPanel()
	{
		return removeDocPanel;
	}
	
	 
}	
	
	