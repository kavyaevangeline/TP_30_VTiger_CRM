package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement product_Lookup;

	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getProduct_Lookup() {
		return product_Lookup;
	}
	
	public void productBL() {
		
		product_Lookup.click();
		
	}
	
}
