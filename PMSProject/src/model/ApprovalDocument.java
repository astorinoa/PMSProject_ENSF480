package model;

/**Models a document that has been approved, approved documents will be added 
 * to the database and available for purchase
 * @author Alexa Astorino, Shreya Patel, Rae McPhail
 */
public class ApprovalDocument {
	private int id;
	private String type;
	private String author;
	private String title;
	private int price;
	private int quantity;
	
	/**
	 * Creates a document object
	 * @param id document id
	 * @param type of document (book, journal, etc.)
	 * @param author of the document
	 * @param title of the document
	 * @param price of the document
	 * @param quantity available
	 */
	public ApprovalDocument(int id, String type, String author, String title, int price, int quantity) {
		this.id = id;
		this.type = type;
		this.author = author;
		this.title = title;
		this.price = price;
		this.quantity = quantity;
	}
	
	public int getId() {
		return id;
	}

	public String getType() {
		return type;
	}

	public String getAuthor() {
		return author;
	}

	public String getTitle() {
		return title;
	}

	public int getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}	
	
	/**
	 * Creates a string to be added to the database that represents the document
	 */
	public String toString() {
		return (id + " - " + title + " - by: "+ author + " - type: " + type+ " - quantity avaliable: "+ quantity + " - $"+ price + " each" );
	}
}
