package contact;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectRepository.ContactPage;
import objectRepository.CreateContactPage;
import objectRepository.CreateOrganisationPage;
import objectRepository.HomePage;
import objectRepository.OrganizationPage;

public class CreateContact_Test extends BaseClass {
	
@Test(groups = "regional_regression")
public void createContact_Test() throws Exception {
	
		//read data from excel file
		String dd =eLibs.readDataFromExcel("Contact", 0, 1);
		String  name=eLibs.readDataFromExcel("Contact", 1, 1);
		String  lastname=eLibs.readDataFromExcel("Contact", 2, 1);
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
	
//	click on contact link
	hp.clickOnContactLink();
	
//	click on 'Create CONTACTS' lookup image
	ContactPage cp = new ContactPage(driver);
	cp.contactLookupImgBL();
	
//	create contact
	CreateContactPage cc = new CreateContactPage(driver);
	cc.createContactBL(driver, dd, name, lastname, orgname);
	
	//validation
	WebElement res = driver.findElement(By.className("dvHeaderText"));
			String actual = res.getText();
	
	wLibs.waitUntilEleToBeVisible(driver, 10, res);
	Assert.assertTrue(actual.contains(lastname));
	
}
}
