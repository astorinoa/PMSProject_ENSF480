package model;

/**Models a promotion. Promotions are viewable buyers who are registered only
 * @author Alexa Astorino, Shreya Patel, Rae McPhail
 */
public class Promotion {
	private int id;
	private String sdate;
	private String edate;
	private String content;
	
	/**
	 * Creates a promotion object
	 * @param id promotion's idea in the database
	 * @param sdate start date, the day the promotion is available
	 * @param edate end date, day the promotion will no longer be available
	 * @param content the details of the promotion
	 */
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
	
	/**
	 * Creates a string to be added to the database that represents the promotion
	 */
	public String toString() {
		return (id + " - starts:" + sdate + " - until: "+ edate + " - content: " + content );
	}
}
