package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {

	//organization lookup image
	@FindBy(xpath = "//img[contains(@title,'Create Organization')]")
	private WebElement org_lookup;

	public OrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getOrg_lookup() {
		return org_lookup;
	}

	public void organizationBL() {
		
		org_lookup.click();
		
	}
	
	
}
