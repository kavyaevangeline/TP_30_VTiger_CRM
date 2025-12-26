package AutomationTestingPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Worldometer_Test {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://www.worldometers.info/geography/countries-of-the-world/");
		
		driver.findElement(By.xpath("//button[@id='menu-button-5']")).click();
		
		String optionName = "Food & Agriculture";
		String country = "India";
		//dropdown option
		driver.findElement(By.xpath("//el-menu/descendant::a[contains(text(),'"+optionName+"')]")).click();

		//country option
		driver.findElement(By.xpath("//ul/li/a[contains(text(),'"+country+"')]")).click();
		
		//undernourished option
		driver.findElement(By.xpath("//span[text()='Undernourished']")).click();
		
		WebElement undernour = driver.findElement(By.xpath("//div[@class=\"not-prose bg-white border rounded shadow-sm text-center mx-auto max-w-xl\"]/descendant::span[contains(@class,'text-2xl font-bold')]"));
		String undervalue=undernour.getText();
		System.out.println(undervalue);
		
		WebElement graph = driver.findElement(By.xpath("//*[name()='g' and  contains(@class,'highcharts-label highcharts-tooltip highcharts-color-undefined')]"));
		
		Actions action=new Actions(driver);
		action.moveToElement(graph).perform();
		
		

		
		
	}

}
