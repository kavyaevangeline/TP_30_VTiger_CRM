package objectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtils;

public class HomePage extends WebDriverUtils{

	//declaration
	@FindBy(xpath = "//a[text()='Calendar']")
	private WebElement calendar_link;
	
	@FindBy(linkText = "Leads")
	private WebElement leads_link;
	
	@FindBy(linkText = "Organizations")
	private WebElement organizations_link;
	
	@FindBy(linkText = "Contacts")
	private WebElement contacts_link;
	
	@FindBy(linkText  = "Opportunities")
	private WebElement opportunities_link;
	
	@FindBy(linkText = "Products")
	private WebElement products_link;
	
	@FindBy(linkText = "Documents")
	private WebElement documents_link;
	
	@FindBy(linkText = "Email")
	private WebElement email_link;
	
	@FindBy(linkText = "Trouble Tickets")
	private WebElement troubleTickets_link;
	
	@FindBy(linkText = "Dashboard")
	private WebElement dashboard_link;
	
	@FindBy(linkText = "More")
	private WebElement more_link;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement admin_img;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOut_link;
	
	@FindBy(xpath = "//input[@class='searchBox']")
	private WebElement search_txtfield;
	
	@FindBy(xpath = "//input[@class='searchBtn']")
	private WebElement search_button;
	
	//initialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//getter methods
	
	public WebElement getCalendar_link() {
		return calendar_link;
	}

	public WebElement getLeads_link() {
		return leads_link;
	}

	public WebElement getOrganizations_link() {
		return organizations_link;
	}

	public WebElement getContacts_link() {
		return contacts_link;
	}

	public WebElement getOpportunities_link() {
		return opportunities_link;
	}

	public WebElement getProducts_link() {
		return products_link;
	}

	public WebElement getDocuments_link() {
		return documents_link;
	}

	public WebElement getEmail_link() {
		return email_link;
	}

	public WebElement getTroubleTickets_link() {
		return troubleTickets_link;
	}

	public WebElement getDashboard_link() {
		return dashboard_link;
	}

	public WebElement getMore_link() {
		return more_link;
	}
	
	public WebElement getAdmin_img() {
		return admin_img;
	}

	public WebElement getSignOut_link() {
		return signOut_link;
	}
	
	public WebElement getSearch_txtfield() {
		return search_txtfield;
	}

	public WebElement getSearch_button() {
		return search_button;
	}
	
	//business logic
	public void clickOnCalendarLink() {
		calendar_link.click();
		
	}
	
	public void clickOnLeadsLink() {
		
		leads_link.click();
	}
	
	public void clickOnOrganizationLink() {
		
		organizations_link.click();
	}
	
	public void clickOnContactLink() {
		
		contacts_link.click();
	}
	
	public void clickOnOppurtunityLink() {
		
		opportunities_link.click();
	}
	
	public void clickOnProductLink() {
		
		products_link.click();
	}
	
	public void clickOnDocumentsLink() {
		
		documents_link.click();
	}
	
	public void clickOnEmailLink() {
		
		email_link.click();
	}
	
	public void clickOnTrobleTicLink() {
		
		troubleTickets_link.click();
	}

	public void clickOnSignOut(WebDriver driver) {
		
		admin_img.click();
		clickOnElementUsingJSE(driver, signOut_link);
		
	}
	
	
	

	
}
