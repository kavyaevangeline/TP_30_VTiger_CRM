package objectRepository;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunitiesPage {

	@FindBy(xpath = "//img[@alt='Create Opportunity...']")
	private WebElement opport_Lookup;
	
	@FindBy(xpath = "//a[@title='Opportunities']")
	private  List<WebElement> links;
	
	@FindBy(xpath = "//a[text()='del']")
	private WebElement delete;

	
	public OpportunitiesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getOpport_Lookup() {
		return opport_Lookup;
	}
	
	public WebElement getDelete() {
		return delete;
	}
	
	public void Opportunity_Lookup() {
		
		opport_Lookup.click();
		
	}
	
public void delteopportunityBL(WebDriver driver, String oppname) throws InterruptedException {
		
		for(WebElement link: links) {
			String actualopp = link.getText();
			if(actualopp.equals(oppname)) {
				break;
			}
		}
		delete.click();
			
		Alert al=driver.switchTo().alert();
		al.accept();

	}
	
	
}
