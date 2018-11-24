package control;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.*;

public class ViewDocumentsController extends Driver{
	/**
	 * have access to the database
	 */
	public ViewDocumentsController(){
		super();
	}
	
	/**
	 * get all the documents by title
	 * @param title of document
	 * @return arrayList of documents with similar title
	 */
	public ArrayList<Document> getDocumentsByTitle(String title){
		String sql = "SELECT * FROM " + docTable + " WHERE TITLE LIKE '%" + title + "%';";
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
	
	/**
	 * get all the documents by author
	 * @param author of document
	 * @return arrayList of documents with similar author
	 */
	public ArrayList<Document> getDocumentsByAuthor(String author){
		String sql = "SELECT * FROM " + docTable + " WHERE AUTHOR LIKE '%" + author + "%';";
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
	
	/**
	 * get all the documents by type
	 * @param type of document
	 * @return arrayList of documents with similar type
	 */
	public ArrayList<Document> getDocumentsByType(String type){
		String sql = "SELECT * FROM " + docTable + " WHERE TYPE LIKE '%" + type + "%';";
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
