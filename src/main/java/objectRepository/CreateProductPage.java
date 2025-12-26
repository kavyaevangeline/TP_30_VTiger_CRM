package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage {

	@FindBy(name = "productname")
	private WebElement productName;
	
	@FindBy(xpath = "(//input[@class='crmbutton small save'])[1]")
	private WebElement save;
	
	public CreateProductPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	public WebElement getProductName() {
		return productName;
	}

	public WebElement getSave() {
		return save;
	}
	
	public void productBL(String prod) {
		
		productName.sendKeys(prod);
		save.click();
		
	}
	
}
