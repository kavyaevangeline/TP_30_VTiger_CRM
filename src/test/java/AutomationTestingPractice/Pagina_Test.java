package AutomationTestingPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Pagina_Test {
public static void main(String[] args) {
	WebDriver driver=new ChromeDriver();
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	
	driver.get("https://testautomationpractice.blogspot.com/");
	
	WebElement pag = driver.findElement(By.xpath("//a[text()='1']"));
	Actions action=new Actions(driver);
	action.moveToElement(pag).perform();
	
	String exp="Portable Charger";
	
	for(int i=2;;i++) {//if we don't write try and catch we will get NoSuchElementException
		
		try {
		for(int j=1;;j++) {
			WebElement element = driver.findElement(By.xpath("(//div[@id='HTML8']/div/descendant::tbody/tr/td[2])["+j+"]"));
			String result=element.getText();
		System.out.println(result);
		if(result.equals(exp)) {
			driver.findElement(By.xpath("//div[@id=\"HTML8\"]/descendant::td[text()='Portable Charger']/following-sibling::td/following-sibling::td/input[@type=\"checkbox\"]")).click();
			return;
			//break; continuous loop
		}
		}
		}catch (Exception e) {
			driver.findElement(By.xpath("//ul[@id=\"pagination\"]/li/a[text()="+i+"]")).click();
		}
		
	}
}
}
