package control;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Document;

public class PromotionsController extends Driver{
	
	public PromotionsController(){
		super();
	}
	
	
	public ArrayList<Promotion> getPromotions(){
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
