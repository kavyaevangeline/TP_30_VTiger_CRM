package AutomationTestingPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Slider_Test {
	public static void main(String[] args) throws Exception{
		
		WebDriver driver=new ChromeDriver();
		
		String eachlink="";
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://testautomationpractice.blogspot.com/");
		
		Actions action=new Actions(driver);
		
		WebElement lslider = driver.findElement(By.xpath("//span[@class=\"ui-slider-handle ui-corner-all ui-state-default\"]/preceding-sibling::span"));//left slider
	
		WebElement rslider = driver.findElement(By.xpath("//span[@class=\"ui-slider-handle ui-corner-all ui-state-default\"]/following-sibling::span"));//right slider
		Thread.sleep(3000);
		action.dragAndDropBy(lslider, 15, 0).perform();
		
		WebDriverWait ew= new WebDriverWait(driver, Duration.ofSeconds(10));
		ew.until(ExpectedConditions.elementToBeClickable(rslider));
		action.clickAndHold(rslider).moveByOffset(59, 0).release().build().perform();
		
	}
}
