package AutomationTestingPractice;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLink_Test {
public static void main(String[] args){
	
	WebDriver driver=new ChromeDriver();
	
	String eachlink="";
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.get("https://testautomationpractice.blogspot.com/");
	
	List<WebElement> brokenlink = driver.findElements(By.xpath("//div[@id=\"broken-links\"]/a"));
	
	for(WebElement element: brokenlink) {
		try {
			//getting the attributes of string
			eachlink= element.getAttribute("href");
			
			//converting string to url
			URL url = new URL(eachlink);
			
			//opening the connection
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			
			if(con.getResponseCode()>=400) {
				System.out.println(" Failed"+eachlink+"***"+con.getResponseCode()+"****"+con.getResponseCode());
			}
		} catch (Exception e) {
			//empty link
			System.out.println("each link failed "+eachlink);
		}
		
	}
}
}
