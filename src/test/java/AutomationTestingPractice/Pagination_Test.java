package AutomationTestingPractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Pagination_Test {
public static void main(String[] args) {
	WebDriver driver=new ChromeDriver();
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.get("https://testautomationpractice.blogspot.com/");
	
	WebElement pag = driver.findElement(By.xpath("//a[text()='1']"));
	Actions action=new Actions(driver);
	action.moveToElement(pag).perform();
	
	
	List<WebElement> button = driver.findElements(By.xpath("//a[@href='#']"));
	
	for(WebElement element:button) {
		element.click();
		WebElement des = driver.findElement(By.xpath("//a[text()='3']"));
		if(des.equals(element))
			break;
	}
	driver.findElement(By.xpath("//div[@id=\"HTML8\"]/descendant::td[text()='Portable Charger']/following-sibling::td/following-sibling::td/input[@type=\"checkbox\"]")).click();
}
}
