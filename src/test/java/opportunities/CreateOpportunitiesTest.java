package opportunities;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

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
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.FileUtils;
import genericUtilities.JavaUtils;
import genericUtilities.WebDriverUtils;
import genericUtilities.ExcelUtils;
import objectRepository.CreateOpportunityPage;
import objectRepository.CreateOrganisationPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.OpportunitiesPage;
import objectRepository.OrganizationPage;

public class CreateOpportunitiesTest extends BaseClass {
	
	@Test(groups = "regional_regression")
public void createOpportunities() throws Exception {
	
	//read data from excel file
	String oppname =eLibs.readDataFromExcel("Opportunity", 0, 1)+jLibs.getRandomNo();
	String reltoDD=eLibs.readDataFromExcel("Opportunity", 1, 1);
	String salessDD=eLibs.readDataFromExcel("Opportunity", 2, 1);
	String date=eLibs.readDataFromExcel("Opportunity", 3, 1);
	String month=eLibs.readDataFromExcel("Opportunity", 4, 1);
	String orgname = eLibs.readDataFromExcel("Organisation", 0, 1)+jLibs.getRandomNo();
	String loc = eLibs.readDataFromExcel("Organisation", 1, 1);
	
//	click on organisation link
	HomePage hp = new HomePage(driver);
	hp.clickOnOrganizationLink();
	
	//create orginasination
	OrganizationPage orgpage=new OrganizationPage(driver);
	orgpage.organizationBL();
	
	CreateOrganisationPage createorg = new CreateOrganisationPage(driver);
	createorg.creatOrganisationMandaBL(orgname, loc);
	
	Thread.sleep(3000);
//	click on 'Oppurtunities' link
	hp.clickOnOppurtunityLink();
	
//	click on 'Create Oppurtunities' lookup image
	OpportunitiesPage op = new OpportunitiesPage(driver);
	op.Opportunity_Lookup();

//	create opportunity
	CreateOpportunityPage cp = new CreateOpportunityPage(driver);
	cp.opportunityBL(driver, oppname, reltoDD, orgname, date, month, salessDD);
	
	//validation
		WebElement res = driver.findElement(By.className("dvHeaderText"));
				String actual = res.getText();
		
				wLibs.waitUntilEleToBeVisible(driver, 10, res);
				Assert.assertTrue(actual.contains(oppname));
		
}
}
