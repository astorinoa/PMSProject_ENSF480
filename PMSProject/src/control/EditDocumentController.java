package control;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.*;

public class EditDocumentController extends Driver{

	public EditDocumentController(){
		super();
	}
	
	
	public void updateDocument (Document d){
		String sql = "UPDATE " + docTable + " SET AUTHOR = '" + d.getAuthor() + "', TITLE = '" + d.getTitle() +
				"', PRICE = "+ d.getPrice()+", QUANTITY = "+ d.getQuantity() + " WHERE DOCUMENT_ID= " + d.getId();
		try{
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}
	
	public void addDocument (Document d){
		String sql = "INSERT INTO " + docTable +
				" VALUES ( '" + d.getType() + "', '" + 
				d.getAuthor() + "', '" + 
				d.getTitle() + "', " +
				d.getPrice() + ", " +
				d.getQuantity() + ");";
		try{
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
			
	}
	
	public void deleteDocument (Document d){
		String sql = "DELETE FROM " + docTable + " WHERE ID=" + d.getId();
		try{
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		
	}
	
	public ArrayList<Document> getDocuments(){
		String sql = "SELECT * FROM " + docTable;
		ResultSet document;
		ArrayList<Document> temp = new ArrayList<Document>();
		try {
			stmt = conn.createStatement();
			document = stmt.executeQuery(sql);
			while(document.next())
			{
				temp.add(new Document(document.getInt("DOCUMENT_ID"),
						document.getString("TYPE"), 
						document.getString("AUTHOR"), 
						document.getString("TITLE"), 
						document.getInt("PRICE"),
						document.getInt("QUANTITY")));
			}
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return temp;
	}
}
