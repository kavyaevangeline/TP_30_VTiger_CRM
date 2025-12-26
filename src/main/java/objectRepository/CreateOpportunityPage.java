package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtils;

public class CreateOpportunityPage extends WebDriverUtils {

	@FindBy(name = "potentialname")
	private WebElement oppName;
	
	@FindBy(id = "related_to_type")
	private WebElement relateToDD;
	
	@FindBy(xpath = "(//img[@src='themes/softed/images/select.gif'])[1]")
	private WebElement relto_Lookup;
	
	//organisation child window
	@FindBy(id = "search_txt")
	private WebElement searchtxt;
	
	@FindBy(xpath = "//input[@name='search']")
	private WebElement searchbtn;
	
	//expected close date lookup image
	@FindBy(xpath = "(//img[@src='themes/softed/images/btnL3Calendar.gif'])[2]")
	private WebElement expcloseDate_Lookup;
	
	@FindBy(name = "sales_stage")
	private WebElement salesDD;
	
	@FindBy(xpath = "(//input[@class='crmbutton small save'])[1]")
	private WebElement save;
	
	public CreateOpportunityPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	public WebElement getOppName() {
		return oppName;
	}

	public WebElement getRelateToDD() {
		return relateToDD;
	}

	public WebElement getRelto_Lookup() {
		return relto_Lookup;
	}

	public WebElement getSearchtxt() {
		return searchtxt;
	}

	public WebElement getSearchbtn() {
		return searchbtn;
	}

	public WebElement getExpcloseDate_Lookup() {
		return expcloseDate_Lookup;
	}

	public WebElement getSalesDD() {
		return salesDD;
	}

	public WebElement getSave() {
		return save;
	}
	
	public void opportunityBL(WebDriver driver,String oppname, String relatodd, String orgname,String date,String month, String saledd) {
		
//		Enter valid data in 'Opportunity Name'
		oppName.sendKeys(oppname);
//		click on 'Related To' drop down and select particular option
		dropDownUsingContainsVisibleText(relateToDD, relatodd);
//		click on 'Create Related To' lookup image
		relto_Lookup.click();
		//switch to childwin
		switchToWindow(driver, "Accounts&action");
		searchtxt.sendKeys(orgname);
		searchbtn.click();
//		click on particular link in 'Organization Name'.
		driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
		switchToWindow(driver, "Potentials&action");
		expcloseDate_Lookup.click();
//		Click on 'Sales Stage' and select particular option
		dropDownUsingContainsVisibleText(salesDD, saledd);
//		click on save button
		save.click();
		
	}
	
	
}
