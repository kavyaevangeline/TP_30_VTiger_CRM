package AutomationTestingPractice;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Pagination_2_Test {
	public static void main(String[] args)throws Exception {
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement pag = driver.findElement(By.xpath("//a[text()='1']"));
		Actions action=new Actions(driver);
		action.moveToElement(pag).perform();
		
		for(;;) {
		try {
				List<WebElement> pagen = driver.findElements(By.xpath("//div[@class='table-container']/descendant::td"));
				
				for(WebElement elem: pagen) {
					elem.getText();
//					WebElement portcharg = driver.findElement(By.xpath("//div[@id='HTML8']/descendant::td[text()='Portable Charger']/following-sibling::td/following-sibling::td/input[@type='checkbox']"));
//					if(elem.equals(portcharg)) {
//						driver.findElement(By.xpath("//div[@id=\"HTML8\"]/descendant::td[text()='Portable Charger']/following-sibling::td/following-sibling::td/input[@type=\"checkbox\"]")).click();
//						break;
//					}
				}
				}catch (Exception e) {
					driver.findElement(By.xpath("//a[@href='#']")).click();
				}
//				List<WebElement> button = driver.findElements(By.xpath("//a[@href='#']"));
//				for(WebElement element:button) {
//					element.click();
//					WebElement portcharg = driver.findElement(By.xpath("//div[@id='HTML8']/descendant::td[text()='Portable Charger']/following-sibling::td/following-sibling::td/input[@type='checkbox']"));
//					if(elem.equals(portcharg)) {
//						driver.findElement(By.xpath("//div[@id=\"HTML8\"]/descendant::td[text()='Portable Charger']/following-sibling::td/following-sibling::td/input[@type=\"checkbox\"]")).click();
//						break;
//					}
//				}	
	}
}
}	
//			WebElement des = driver.findElement(By.xpath("//a[text()='3']"));	
