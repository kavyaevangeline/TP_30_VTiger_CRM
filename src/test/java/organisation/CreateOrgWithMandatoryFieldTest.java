package organisation;


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
import objectRepository.CreateOrganisationPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.OrganizationPage;

public class CreateOrgWithMandatoryFieldTest extends BaseClass {
	
	@Test
public void createOrgWithMandatoryField() throws Exception {
	
	//read data from excel file
	String orgname= eLibs.readDataFromExcel("Organisation", 0, 1)+jLibs.getRandomNo();
	String location = eLibs.readDataFromExcel("Organisation", 1, 1);
	
//	click on 'ORGANIZATIONS' link
	HomePage hp = new HomePage(driver);
	hp.clickOnOrganizationLink();
	
//	click on 'Create Organization' lookup image
	OrganizationPage op = new OrganizationPage(driver);
	op.organizationBL();
	
//	create organization
	CreateOrganisationPage cop = new CreateOrganisationPage(driver);
	cop.creatOrganisationMandaBL(orgname, location);
	
//validation
		WebElement res = driver.findElement(By.className("dvHeaderText"));
		String actual = res.getText();

		wLibs.waitUntilEleToBeVisible(driver, 10, res);
		
		Assert.assertTrue(actual.contains(orgname));
	
}
}
