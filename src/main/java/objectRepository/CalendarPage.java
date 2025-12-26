package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtils;

public class CalendarPage extends WebDriverUtils {

	//day link
	@FindBy(linkText = "Day")
	private WebElement day_link;
	
	//time
	@FindBy(xpath = "//td[text()='08:00AM']")
	private WebElement time_p;
	
	//add event
	@FindBy(xpath = "//input[@name='subject']")
	private WebElement even_name_p;
	
	@FindBy(id = "eventstatus")
	private WebElement event_statusDD_p;
	
	@FindBy(id = "endhr")
	private WebElement eventend_hr_p;
	
	@FindBy(id = "endmin")
	private WebElement eventend_min_p;
	
	@FindBy(id = "endfmt")
	private WebElement eventend_ap_p;
	
	//calendar lookup image
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Calendar.gif']")
	private WebElement calendar_lookup_p;
	
	@FindBy(xpath = "//td[text()='December, 2025']/ancestor::table[@cellspacing='0']/descendant::td[text()='10']")
	private WebElement calendar_date_p;
	
	//reminder link
	@FindBy(linkText = "Reminder")
	private WebElement reminder_p;
	
	//yes checkbox
	@FindBy(xpath = "//input[@value='Yes']")
	private WebElement checkbox_p;
	
	//save button
	@FindBy(xpath = "//input[@name='eventsave']")
	private WebElement evenSave_btn_p;
	
	public CalendarPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	public WebElement getDay_link() {
		return day_link;
	}

	public WebElement getTime_p() {
		return time_p;
	}

	public WebElement getEven_name_p() {
		return even_name_p;
	}

	public WebElement getEvent_statusDD_p() {
		return event_statusDD_p;
	}

	public WebElement getEventend_hr_p() {
		return eventend_hr_p;
	}

	public WebElement getEventend_min_p() {
		return eventend_min_p;
	}

	public WebElement getEventend_ap_p() {
		return eventend_ap_p;
	}

	public WebElement getCalendar_lookup_p() {
		return calendar_lookup_p;
	}

	public WebElement getCalendar_date_p() {
		return calendar_date_p;
	}

	public WebElement getReminder_p() {
		return reminder_p;
	}

	public WebElement getCheckbox_p() {
		return checkbox_p;
	}

	public WebElement getEvenSave_btn_p() {
		return evenSave_btn_p;
	}
	
	public void createcalendarPageBL(WebDriver driver, String evenname_tx,String eventdd, String hrdd, String mindd, String apdd) throws InterruptedException {
		
		//click on day link
		day_link.click();
		Thread.sleep(3000);
		time_p.click();
		//enter data in event name
		even_name_p.sendKeys(evenname_tx);
		//event drop down
		dropDownUsingContainsVisibleText(event_statusDD_p, eventdd);
		//hour dd
		dropDownUsingContainsVisibleText(eventend_hr_p, hrdd);
		//minute dd
		dropDownUsingContainsVisibleText(eventend_min_p, mindd);
		//am pm dd
		dropDownUsingContainsVisibleText(eventend_ap_p, apdd);
		//click on calendar lookup img
		calendar_lookup_p.click();
		//click on date
		calendar_date_p.click();
		//click on reminder link
		reminder_p.click();
		//click on yes checkbox
		checkbox_p.click();
		//click on save
		evenSave_btn_p.click();
		
	}
	
}
