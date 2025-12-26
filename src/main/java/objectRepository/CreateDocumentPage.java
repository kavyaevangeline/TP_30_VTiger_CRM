package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateDocumentPage {

	@FindBy(xpath = "//input[@name=\"notes_title\"]")
	private WebElement title;
	
	@FindBy(id = "filename_I__")
	private WebElement chooseFile;
	
	@FindBy(id = "fileversion")
	private WebElement version;
	
	@FindBy(xpath = "(//input[@class='crmbutton small save'])[1]")
	private WebElement save;
	
	public CreateDocumentPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	public WebElement getTitle() {
		return title;
	}

	public WebElement getChooseFile() {
		return chooseFile;
	}

	public WebElement getVersion() {
		return version;
	}

	public WebElement getSave() {
		return save;
	}
	
	public void createDocumentBL(String titles) {
		
		title.sendKeys(titles);
		save.click();
		
	}
	
}
