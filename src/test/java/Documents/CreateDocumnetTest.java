package Documents;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.FileUtils;
import genericUtilities.JavaUtils;
import genericUtilities.WebDriverUtils;
import genericUtilities.ExcelUtils;
import objectRepository.CreateDocumentPage;
import objectRepository.DocumentsPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class CreateDocumnetTest extends BaseClass {
	
	@Test
public void createDocumnet() throws Exception {

		//read data from excel file
		String title=eLibs.readDataFromExcel("Documents", 0, 1);
	
	HomePage hp = new HomePage(driver);
	hp.clickOnDocumentsLink();
	
	//click on document link
	DocumentsPage dp = new DocumentsPage(driver);
	dp.clickOnDocument_Lookup();;
	
	//create document
	CreateDocumentPage cd = new CreateDocumentPage(driver);
	cd.createDocumentBL(title);
	
	WebElement res = driver.findElement(By.className("dvHeaderText"));
			String actual = res.getText();
			wLibs.waitUntilEleToBeVisible(driver, 10, res);
			
			Assert.assertTrue(actual.contains(title));
	
}
}
