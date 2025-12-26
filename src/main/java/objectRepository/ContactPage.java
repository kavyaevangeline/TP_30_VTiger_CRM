package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {

	//contact lookup image
	@FindBy(xpath = "//img[@alt='Create Contact...']")
	private WebElement contact_lookup;
	
	public ContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getContact_lookup() {
		return contact_lookup;
	}
	
	public void contactLookupImgBL() {
		contact_lookup.click();
	}
	
}
