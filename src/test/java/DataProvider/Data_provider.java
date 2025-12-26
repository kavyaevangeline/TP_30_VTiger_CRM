package DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Data_provider {
	
	@Test(dataProvider = "storedata")
	public void getdata(String company, Object num) {//gives ascii value if we put any character 
		System.out.println("company-->"+ company+" number-->"+ num);
	}

	@DataProvider
	public Object[][] storedata() {
		
		Object[][] obj = new Object[3][2];
		obj[0][0] = "ibm";
		obj[0][1] = 25;
		
		obj[1][0] = "infosys";
		obj[1][1] = 30;
		
		obj[2][0]="honey well";
		obj[2][1]='a';
		return obj;
		
	}
	
}
