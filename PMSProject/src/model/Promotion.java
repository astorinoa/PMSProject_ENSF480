package model;

public class Promotion {
	private int id;
	private String sdate;
	private String edate;
	private String content;
	
	public Promotion(int id, String sdate, String edate, String content) {
		this.id = id;
		this.sdate = sdate;
		this.edate = edate;
		this.content = content;
	}

	public int getId() {
		return id;
	}

	public String getSdate() {
		return sdate;
	}

	public String getEdate() {
		return edate;
	}

	public String getContent() {
		return content;
	}
	
	public String toString() {
		return (id + " - starts:" + sdate + " - until: "+ edate + " - content: " + content );
	}
}
