package AutomationTestingPractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Worldometer_holysee {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.worldometers.info/world-population/");

        String country = "Holy See";
        boolean found=false;
       
        Thread.sleep(3000);
        WebElement act = driver.findElement(By.xpath("//h2[text()='How many people have ever lived on earth?']"));
        Actions action=new Actions(driver);
        action.moveToElement(act).perform();
     
       while(true) {
    	   
    	   List<WebElement> countries = driver.findElements(By.xpath("//td[@class=\"px-2 border-e border-zinc-200 py-1.5 border-b font-bold text-start\"]"));
           for(WebElement ele: countries) {
           	String list = ele.getText();
           	if(list.equals(country)) {
           		System.out.println("element found");
           		found=true;
           		break;
           	}
           }
           if(found) {
        	   break;
           }
           try {
        	   driver.findElement(By.xpath("//button[text()='›']")).click();
         	  
           }catch (Exception e) {
    		System.out.println("reached last page country not found");
        	   
    	}
       }
        	
      
    
	}
}
