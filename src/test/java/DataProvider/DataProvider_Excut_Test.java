package DataProvider;

import org.testng.annotations.Test;

public class DataProvider_Excut_Test {
	
	
	@Test(dataProviderClass = DataProvider_data_Test.class, dataProvider = "product_name")
	public void product_getdata(String product, int price) {
		
		System.out.println(product+"--->"+price);
		
	}

	@Test(dataProviderClass = DataProvider_data_Test.class, dataProvider = "login_credentials")
	public void login_getdata(String username, String password) {
		
		System.out.println(username+"--->"+password);
		
	}
	
}
