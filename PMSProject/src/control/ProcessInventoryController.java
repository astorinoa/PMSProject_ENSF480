package control;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Document;

public class ProcessInventoryController extends Driver {
	public ProcessInventoryController()
	{
		super();
	}
	
	//Adds order to the database
	public String makeOrder(String type, int item, int quantity, int cvv, long card)
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
		return "done";
	}
}
