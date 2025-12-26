package products;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

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
import objectRepository.CreateProductPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.ProductPage;

public class CreateProductsTest extends BaseClass{
	
	@Test(retryAnalyzer = genericUtilities.RetryAnalyser.class)
public void createProducts() throws Exception {
	
	//read data from excel file
	String prod = eLibs.readDataFromExcel("Product", 0, 1);
	
//	click on 'PRODUCTS' link
	HomePage hp = new HomePage(driver);
	hp.clickOnProductLink();
	
//	click on 'Create PRODUCTS' lookup image
	ProductPage pp = new ProductPage(driver);
	pp.productBL();
	
//	create product
	CreateProductPage cpp = new CreateProductPage(driver);
	cpp.productBL(prod);
	
	//validation
	 WebElement res = driver.findElement(By.className("lvtHeaderText"));
			String actual = res.getText();
	
	 wLibs.waitUntilEleToBeVisible(driver, 10, res);
	 Assert.assertTrue(actual.contains(prod));

}
}
