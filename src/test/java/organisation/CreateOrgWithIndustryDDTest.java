package organisation;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.FileUtils;
import genericUtilities.JavaUtils;
import genericUtilities.WebDriverUtils;
import genericUtilities.ExcelUtils;
import objectRepository.ContactPage;
import objectRepository.CreateContactPage;
import objectRepository.CreateOrganisationPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.OrganizationPage;

public class CreateOrgWithIndustryDDTest extends BaseClass {
	
	@Test(groups = "regional_regression")
public void createOrgWithIndustryDD() throws Exception {
	
//		read data from excel
			String orgname = eLibs.readDataFromExcel("Organisation", 0, 1)+jLibs.getRandomNo();
			String shipStreet = eLibs.readDataFromExcel("Organisation", 1, 1);
			String indus = eLibs.readDataFromExcel("Organisation", 2, 1);
			String accDD = eLibs.readDataFromExcel("Organisation", 3, 1);
			
//			read data from contact
			String dd = eLibs.readDataFromExcel("Contact", 0, 1);
			String name = eLibs.readDataFromExcel("Contact", 1, 1);
			String lastname = eLibs.readDataFromExcel("Contact", 2, 1);

//	click on 'ORGANIZATIONS' link
	HomePage hp = new HomePage(driver);
	hp.clickOnOrganizationLink();
	
//	click on 'Create Organization' lookup image
	OrganizationPage op = new OrganizationPage(driver);
	op.organizationBL();
	
	//create organisation
	 CreateOrganisationPage cop = new CreateOrganisationPage(driver);
	cop.organisationBL(orgname, shipStreet, indus, accDD);
	
	
	Thread.sleep(3000);
	
//	click on 'CONTACTS' link
	hp.clickOnContactLink();
	
//	click on 'Create CONTACTS' lookup image
	ContactPage cp = new ContactPage(driver);
	cp.contactLookupImgBL();
	
//	create contact
	CreateContactPage ccp = new CreateContactPage(driver);
	ccp.createContactBL(driver, dd, name, lastname, orgname);
	
	//validation
			WebElement res = driver.findElement(By.className("dvHeaderText"));
			String actual = res.getText();

			wLibs.waitUntilEleToBeVisible(driver, 10, res);
			
			Assert.assertTrue(actual.contains(orgname));
	
	}
		}
	