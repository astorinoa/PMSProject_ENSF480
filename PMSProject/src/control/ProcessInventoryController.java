package control;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Document;

public class ProcessInventoryController extends Driver {
	/**
	 * have access to the database
	 */
	public ProcessInventoryController()
	{
		super();
	}
	
	/**
	 * make sure the order can be made
	 * @param type of payment
	 * @param item document id
	 * @param quantity documents want to order
	 * @param cvv security payment info
	 * @param card card number
	 */
	public String checkOrder(String type, int item, int quantity, int cvv, long card)
	{
		String sql = "SELECT * FROM " + docTable + " WHERE DOCUMENT_ID =" + item ;
		ResultSet document;
		Document d = null;
		try {
			stmt = conn.createStatement();
			document = stmt.executeQuery(sql);
			if(document.next())
			{
				d = new Document(document.getInt("DOCUMENT_ID"),
						document.getString("TYPE"), 
						document.getString("AUTHOR"), 
						document.getString("TITLE"), 
						document.getInt("PRICE"),
						document.getInt("QUANTITY"));
			} 
		}		
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		if (d == null ) {
			return "not valid id";
		}
		
		if (d.getQuantity() < quantity) {
			return "not enough quantity";
		}
		return "done";
	}
	
	/**
	 * get price of item based on quantity 
	 * @param item document id
	 * @param quantity number the user wants to buy
	 * @return total price
	 */
	public int getPrice (int item, int quantity)
	{
		String sql = "SELECT * FROM " + docTable + " WHERE DOCUMENT_ID =" + item ;
		ResultSet document;
		Document d = null;
		try {
			stmt = conn.createStatement();
			document = stmt.executeQuery(sql);
			if(document.next())
			{
				d = new Document(document.getInt("DOCUMENT_ID"),
						document.getString("TYPE"), 
						document.getString("AUTHOR"), 
						document.getString("TITLE"), 
						document.getInt("PRICE"),
						document.getInt("QUANTITY"));
			} 
		}		
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return (d.getPrice() * quantity);
	}
	
	
	/**
	 * places the order and updates database
	 * @param type of payment
	 * @param item document id
	 * @param quantity documents want to order
	 * @param cvv security payment info
	 * @param card card number
	 */
	public void placeOrder(String type, int item, int quantity, int cvv, long card)
	{
		String sql = "SELECT * FROM " + docTable + " WHERE DOCUMENT_ID =" + item ;
		ResultSet document;
		Document d = null;
		try {
			stmt = conn.createStatement();
			document = stmt.executeQuery(sql);
			if(document.next())
			{
				d = new Document(document.getInt("DOCUMENT_ID"),
						document.getString("TYPE"), 
						document.getString("AUTHOR"), 
						document.getString("TITLE"), 
						document.getInt("PRICE"),
						document.getInt("QUANTITY"));
			} 
		}		
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		String sql2 = "INSERT INTO `"+orderTable+ "` (`document_id`, `quantity`, `payment_type`, `card_number`, `payment_cvv`) VALUES ( '"
				+ item+ "', '" + quantity +"', '"+ type + "', '"+ card +"', '"+ cvv +"' )";
		int amount = d.getQuantity() - quantity;
		String sql3 = null;
		if (amount > 0) {
			sql3 = "UPDATE " + docTable + " SET QUANTITY = " + amount + " WHERE DOCUMENT_ID= " + d.getId();
		}
		else {
			sql3 = "DELETE FROM " + docTable + " WHERE DOCUMENT_ID=" + d.getId();
		}
		try{
			stmt = conn.createStatement();
			stmt.executeUpdate(sql2);
			stmt.executeUpdate(sql3);			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
}
