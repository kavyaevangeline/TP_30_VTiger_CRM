package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtils;

public class CreateContactPage extends WebDriverUtils {

	
	@FindBy(name = "salutationtype")
	private WebElement firstNameDD;
	
	@FindBy(name = "firstname")
	private WebElement firstName;
	
	@FindBy(name = "lastname")
	private WebElement lastName;
	
	@FindBy(xpath = "(//img[@title='Select'])[1]")
	private WebElement createOrg_lookup;
	
	//organisation child window
	@FindBy(id = "search_txt")
	private WebElement searchtxt;
	
	@FindBy(xpath = "//input[@name='search']")
	private WebElement searchbtn;
	
	//save button
	@FindBy(xpath = "//input[@class='crmbutton small save']")
	private WebElement save;
	
	public CreateContactPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	public WebElement getFirstNameDD() {
		return firstNameDD;
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getCreateOrg_lookup() {
		return createOrg_lookup;
	}

	public WebElement getSearchtxt() {
		return searchtxt;
	}

	public WebElement getSearchbtn() {
		return searchbtn;
	}

	public WebElement getSave() {
		return save;
	}
	
	public void createContactBL(WebDriver driver, String dd, String name, String lastname, String orgname) throws InterruptedException {
		
		firstNameDD.click();
		dropDownUsingVisibleText(firstNameDD, dd);
		firstName.sendKeys(name);
		Thread.sleep(3000);
		lastName.sendKeys(lastname);
		//click on or lookup image
		createOrg_lookup.click();
		switchToWindow(driver, "Accounts&action");
		//create orgination child page
		searchtxt.sendKeys(orgname);
		searchbtn.click();
    	//click on particular link in 'Organization Name'.
		driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
		switchToWindow(driver, "Contacts&action");
		save.click();
		
	}
	
}
