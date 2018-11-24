package control;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.*;


public class PromotionsController extends Driver{
	/**
	 * have access to the database
	 */
	public PromotionsController(){
		super();
	}
	
	/**
	 * get all the promotions from database
	 * @return arrayList of all the promos
	 */
	public ArrayList<Promotion> getPromotions(){
		String sql = "SELECT * FROM " + promoTable;
		ResultSet promo;
		ArrayList<Promotion> temp = new ArrayList<Promotion>();
		try {
			stmt = conn.createStatement();
			promo = stmt.executeQuery(sql);
			while(promo.next())
			{
				temp.add(new Promotion(promo.getInt("PROMOTION_ID"),
						promo.getString("STARTDATE"), 
						promo.getString("ENDDATE"), 
						promo.getString("CONTENT")));
			}
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return temp;
	}

}
