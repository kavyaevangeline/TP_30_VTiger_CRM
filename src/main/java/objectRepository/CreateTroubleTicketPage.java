package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtils;

public class CreateTroubleTicketPage extends WebDriverUtils {

	@FindBy(xpath = "//textarea[@name='ticket_title']")
	private WebElement title;
	
	@FindBy(xpath = "//form[@name='EditView']/descendant::select[@name='assigned_user_id']")
	private WebElement assignToDD;
	
	@FindBy(xpath = "//form[@name='EditView']/descendant::select[@name='ticketpriorities']")
	private WebElement proirityDD;
	
	@FindBy(xpath = "//form[@name='EditView']/descendant::select[@name='ticketstatus']")
	private WebElement statusDD;
	
	@FindBy(xpath = "//input[@class='crmbutton small save']")
	private WebElement save;
	
	public CreateTroubleTicketPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	public WebElement getTitle() {
		return title;
	}

	public WebElement getAssignToDD() {
		return assignToDD;
	}

	public WebElement getProirityDD() {
		return proirityDD;
	}

	public WebElement getStatusDD() {
		return statusDD;
	}

	public WebElement getSave() {
		return save;
	}
	
	public void createTroubleTicketBL(String titl, String assign, String prior, String status) {
		
		title.sendKeys(titl);
		dropDownUsingContainsVisibleText(assignToDD, assign);
		dropDownUsingContainsVisibleText(proirityDD, prior);
		dropDownUsingContainsVisibleText(statusDD, status);
		save.click();
		
	}
	
}
