package calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectRepository.CalendarPage;
import objectRepository.HomePage;

public class CreateCalendarTest extends BaseClass {
	
@Test
public void createCalendarTest() throws Exception {
		
			//read data from excel file
			String eventName = eLibs.readDataFromExcel("Calender", 0, 1)+jLibs.getRandomNo();
			String eventDD= eLibs.readDataFromExcel("Calender", 1, 1);
			String hrDD= eLibs.readnumberFromExcel("Calender", 2, 1);
			String minDD= eLibs.readnumberFromExcel("Calender", 3, 1);
			String apDD= eLibs.readDataFromExcel("Calender", 4, 1);
	
	//click on calendar link
	HomePage hp = new HomePage(driver);
	hp.clickOnCalendarLink();
	
	//create calendar
	CalendarPage cp = new CalendarPage(driver);
	cp.createcalendarPageBL(driver, eventName, eventDD, hrDD, minDD, apDD);
	
}
}
