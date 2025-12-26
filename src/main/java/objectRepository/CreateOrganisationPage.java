package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtils;

public class CreateOrganisationPage extends WebDriverUtils {

	@FindBy(xpath = "//input[@name='accountname']")
	private WebElement orgname;
	
	@FindBy(xpath = "//textarea[@name='ship_street']")
	private WebElement shipStreet;
	
	@FindBy(name = "industry")
	private WebElement indusDD;
	
	@FindBy(name = "accounttype")
	private WebElement accounttypeDD;
	
	@FindBy(xpath = "//input[@class='crmbutton small save']")
	private WebElement save;
	
	public CreateOrganisationPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgname() {
		return orgname;
	}

	public WebElement getShipStreet() {
		return shipStreet;
	}

	public WebElement getIndusDD() {
		return indusDD;
	}

	public WebElement getAccounttypeDD() {
		return accounttypeDD;
	}

	public WebElement getSave() {
		return save;
	}
	
	public void organisationBL(String orgName, String locat, String ind, String account) {
		
		orgname.sendKeys(orgName);
		shipStreet.sendKeys(locat);
		dropDownUsingContainsVisibleText(indusDD, ind);
		dropDownUsingContainsVisibleText(accounttypeDD, account);
		save.click();
	}
	
	public void creatOrganisationMandaBL(String orgName, String locat) {
		
		orgname.sendKeys(orgName);
		shipStreet.sendKeys(locat);
		save.click();
		
	}
}
