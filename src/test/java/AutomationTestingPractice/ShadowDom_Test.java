package AutomationTestingPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDom_Test {
public static void main(String[] args) {
	WebDriver driver=new ChromeDriver();
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.get("https://testautomationpractice.blogspot.com/");
	
	//identify the shadow host-open
	SearchContext shadow_host = driver.findElement(By.xpath("//div[@id=\"shadow_host\"]")).getShadowRoot();
	
	//enter data in blog
	shadow_host.findElement(By.cssSelector("input[type=\"text\"]")).sendKeys("shadow");
	
	//click on checkbox
	shadow_host.findElement(By.cssSelector("input[type=\"checkbox\"]")).click();
	
	//choose file
	shadow_host.findElement(By.cssSelector("[href='https://www.pavantestingtools.com/']~[type='file']")).sendKeys("\"C:\\Users\\hp\\Shadow_host\"");
	
}
}
