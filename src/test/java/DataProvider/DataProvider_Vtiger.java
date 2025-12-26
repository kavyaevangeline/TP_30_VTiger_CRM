package DataProvider;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericUtilities.FileUtils;
import genericUtilities.WebDriverUtils;
import objectRepository.LoginPage;

public class DataProvider_Vtiger {

	
	@Test(dataProvider = "storedata")
	public void getdata(String USERNAME, String PASSWORD) throws Exception {
		
		WebDriver driver = new ChromeDriver();
		
		FileUtils fLibs= new FileUtils();
		WebDriverUtils wLibs = new WebDriverUtils();
		String URL = fLibs.readDataFromPropertyFile("url");
		
		wLibs.maximizeWindow(driver);
		wLibs.waitForPageLoad(driver);
		
			driver.get(URL);
			
//			login to application using data provider
			LoginPage lp = new LoginPage(driver);
			lp.loginPageBL(USERNAME, PASSWORD);
		
	}
	
	@DataProvider
	public Object[][] storedata() {
		
		Object[][] obj = new Object[2][2];
		
		obj[0][0]="admin";
		obj[0][1]="admin";
		
		obj[1][0]="admin";
		obj[1][1]="password";
		return obj;
		
	}
	
}
