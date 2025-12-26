package DataDrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Insert_Query {
	public static void main(String[] args) throws SQLException {
		//step 1: create driver object
		Driver driver = new Driver();
		
		//step 2: register driver
		DriverManager.registerDriver(driver);
		
		//step 3: get connection for database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/tp_30", "root", "root");
		
		//step 4: create statement
		Statement state = con.createStatement();	
	String query = "insert into emp(name, location, mobile, age) values('neelu', 'bangalore', 987364521, 25);";
	
	//step 5: execute query
	int result = state.executeUpdate(query);
	
	System.out.println(result);
	
	//step 6: close database connection
	con.close();

	}//no select unselect
	
}