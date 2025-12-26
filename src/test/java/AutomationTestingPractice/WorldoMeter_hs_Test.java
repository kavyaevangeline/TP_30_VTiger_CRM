package AutomationTestingPractice;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorldoMeter_hs_Test {

	public static void main(String[] args) {
		 WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	        driver.get("https://www.worldometers.info/world-population/");

	        String countryName = "Holy See";

	        while (true) {
	            try {
	                WebElement country = driver.findElement(By.xpath("//a[contains(text(),'" + countryName + "')]"));
	                
	                break;

	            } catch (NoSuchElementException e) {
	                driver.findElement(By.xpath("//button[text()='›']")).click();
	            }
	        }
	        WebElement population = driver.findElement(By.xpath("//table/tbody/tr/td/a[contains(text(),'"+countryName+"')]/../following-sibling::td[@class=\"px-2 border-e border-zinc-200 text-end py-1.5 border-b font-bold\"]"));

	        System.out.println(countryName + " population is: " + population.getText());
	                

	}
}
