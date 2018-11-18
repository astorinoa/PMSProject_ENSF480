package model;

public class Document {
	private int id;
	private String type;
	private String author;
	private String title;
	private int price;
	private int quantity;
	
	public Document(int id, String type, String author, String title, int price, int quantity) {
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
	
	
}
