package DataDrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Where_SQL {

	public static void main(String[] args) throws SQLException {
		//step 1: create driver object
				Driver driver = new Driver();
				
				//step 2: register driver
				DriverManager.registerDriver(driver);
				
				//step 3: get connection for database
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/tp_30", "root", "root");
				
				//step 4: create statement
				Statement state = con.createStatement();	
			String query = "select * from emp where name='ayushi';";
			
			//step 5: execute query
			ResultSet result= state.executeQuery(query);
			
			System.out.println(result.getMetaData()+" ");
			
			while(result.next()) {
				System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3));
			}
			
			//step 6: close database connection
			con.close();

				

	}

}
