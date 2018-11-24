package control;

import java.sql.SQLException;

public class ProcessInventoryController extends Driver {
	public ProcessInventoryController()
	{
		super();
	}
	
	//Adds order to the database
	public boolean makeOrder(String type, int item, int quantity, int cvv, int card)
	{
		String sql = "INSERT INTO `"+orderTable+ "` (`document_id`, `quantity`, `payment_type`, `card_number`, `payment_cvv`) VALUES ( '"
				+ item+ "', '" + quantity +"', '"+ type + "', '"+ card +"', '"+ cvv +"' )";
		
		try{
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			return true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return false;
		}
	}
}
