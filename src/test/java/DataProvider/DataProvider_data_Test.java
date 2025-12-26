package DataProvider;

import org.testng.annotations.DataProvider;

public class DataProvider_data_Test {

	@DataProvider(name = "product_name")
	public Object[][] product() {
		
		Object[][] obj = new Object[3][2];
		
		obj[0][0]="samsung";
		obj[0][1]=50000;
		
		obj[1][0]="iphone";
		obj[1][1]=50000;
		
		obj[2][0]="realme";
		obj[2][1]=20000;
		return obj;
	}
	
	@DataProvider(name = "login_credentials")//if we are providing name mandatorily have to call name only
	public Object[][] login(){
		
		Object[][] obj = new Object[2][2];
		
		obj[0][0]="admin";
		obj[0][1]="admin";
		
		obj[1][0]="username";
		obj[1][1]="password";
		return obj;
		
	}
	
}
