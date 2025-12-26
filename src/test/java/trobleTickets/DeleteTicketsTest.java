package trobleTickets;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.FileUtils;
import genericUtilities.JavaUtils;
import genericUtilities.WebDriverUtils;
import genericUtilities.ExcelUtils;
import objectRepository.CreateTroubleTicketPage;
import objectRepository.HomePage;
import objectRepository.TroubleTicketPage;

public class DeleteTicketsTest extends BaseClass {
	
	@Test
	public void deleteTickets() throws Exception {
	
		//read data from excel 
				String title=eLibs.readDataFromExcel("Trouble Ticket", 0, 1);
				String assignDD=eLibs.readDataFromExcel("Trouble Ticket", 1, 1);
				String proiDD=eLibs.readDataFromExcel("Trouble Ticket", 2, 1);
				String statusDD=eLibs.readDataFromExcel("Trouble Ticket", 3, 1);
				
				//click on trouble ticket link
				HomePage hp = new HomePage(driver);
				hp.clickOnTrobleTicLink();
				
				//click on create look up image
				TroubleTicketPage tt = new TroubleTicketPage(driver);
				tt.troubleTicketBL();
				
//				create trouble ticket
				CreateTroubleTicketPage ctp = new CreateTroubleTicketPage(driver);
				ctp.createTroubleTicketBL(title, assignDD, proiDD, statusDD);
	
//			validation
		 WebElement res = driver.findElement(By.className("dvHeaderText"));
		 String actual = res.getText();
			wLibs.waitUntilEleToBeVisible(driver, 10, res);
				
			Assert.assertTrue(actual.contains(title));
				
		//click on trouble ticket link
				hp.clickOnTrobleTicLink();
				
			//delete
			tt.deleteTroubleTicket(driver, title);
		
					
}}
