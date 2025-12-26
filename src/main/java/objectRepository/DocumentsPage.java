package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DocumentsPage {

	@FindBy(xpath = "//img[@title='Create Document...']")
	private WebElement document_lookup;
	
	public DocumentsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getDocument_lookup() {
		return document_lookup;
	}

	public void clickOnDocument_Lookup() {
		document_lookup.click();
	}
	
	
}
