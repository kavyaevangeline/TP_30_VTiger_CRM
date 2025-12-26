package AutomationTestingPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;

public class FireFoxloginsignout extends BaseClass {
	
	@Test
	public void login() throws Exception {
		
		String USERNAME = fLibs.readDataFromPropertyFile("username");
		String PASSWORD = fLibs.readDataFromPropertyFile("password");
		
		driver.findElement(By.className("user_name")).sendKeys(USERNAME);
		driver.findElement(By.className("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
	}
	
	@Test
	public void signout() {
		
		WebElement admin= driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
		admin.click();
	}

}
