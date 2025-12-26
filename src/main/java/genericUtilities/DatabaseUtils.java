package genericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DatabaseUtils {

	Connection conn = null;
	 ResultSet result = null;
			
	 /**
	  * This method is used to connect to DB
	  * @author Kavya
	  * @throws SQLException
	  */
	public void connectToDB() throws SQLException {
		//register the database
		Driver driver= new Driver();
		DriverManager.registerDriver(driver);
		
		//get connection
		conn = DriverManager.getConnection(IpathConstants.dburl, IpathConstants.dbusername, IpathConstants.dbpassword);
	}
	
	/**
	 * This method is used to execute query
	 * @author Kavya
	 * @param query
	 * @return
	 * @throws SQLException
	 */
	public ResultSet executeQuery(String query) throws SQLException {
		
		//create statement
		Statement state = conn.createStatement();
		
		//execute query
		result = state.executeQuery(query);
		 return result;
	}
	
	/**
	 * This method is used to update query
	 * @author Kavya
	 * @param query
	 * @return
	 * @throws SQLException
	 */
	public int updateQuery(String query) throws SQLException {
		
		//create statement
		Statement state = conn.createStatement();
		
		int res =state.executeUpdate(query);
		return res;
	}
	
	/**
	 * This method is used to close DB connection
	 * @author Kavya
	 * @throws SQLException
	 */
	public void disconnectDB() throws SQLException {
		
		conn.close();
		
	}
}
