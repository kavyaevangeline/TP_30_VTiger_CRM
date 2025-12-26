package objectRepository;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TroubleTicketPage {

	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement trouTic_Lookup;
	
	@FindBy(xpath = "//a[@title='Trouble Tickets']")
	private List<WebElement> links;
	
	@FindBy(xpath = "//a[text()='del']")
	private WebElement delete;

	public TroubleTicketPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getTrouTic_Lookup() {
		return trouTic_Lookup;
	}
	
	public WebElement getDelete() {
		return delete;
	}
	
	public void troubleTicketBL() {
		
		trouTic_Lookup.click();
		
	}
	
	public void deleteTroubleTicket(WebDriver driver, String title) {
		
		for(WebElement link: links) {
			String actualticket = link.getText();
			if(actualticket.equals(title)) {
				break;
			}
	}
		delete.click();

		Alert al=driver.switchTo().alert();
		al.accept();
	}

}
