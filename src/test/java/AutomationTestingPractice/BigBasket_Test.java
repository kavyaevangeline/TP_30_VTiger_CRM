package AutomationTestingPractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BigBasket_Test {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://www.bigbasket.com/");
		
		//click on category
		WebElement category = driver.findElement(By.xpath("//button[@id='headlessui-menu-button-:Ramkj6:']"));
		Actions action=new Actions(driver);
		
		action.moveToElement(category).click().perform();
	
			List<WebElement> firstCategry = driver.findElements(By.xpath("(//nav[@role=\"none\"])[1]/descendant::a[@role=\"none\"]"));
			 for(WebElement ele: firstCategry) {
				 WebElement eachli=ele;
				 action.moveToElement(eachli).perform();
				 String eachele=eachli.getText();
				 System.out.println(eachele);
				List<WebElement> subcategry = driver.findElements(By.xpath("(//nav[@role='none'])[1]/ul[@class=\"jsx-1259984711 w-56 px-2.5 bg-silverSurfer-200 text-darkOnyx-800 max-h-120 overflow-y-auto scroll-smooth\"]/descendant::a"));
				for(WebElement subelem: subcategry) {
					WebElement eachsublist= subelem;
					action.moveToElement(eachsublist).perform();
					String subele = eachsublist.getText();
							System.out.println(subele);
							List<WebElement> secsubcatrgy = driver.findElements(By.xpath("(//nav[@role='none'])[1]/ul[@class=\"jsx-1259984711 w-56 px-2.5 bg-white text-darkOnyx-800 rounded-r-xs max-h-120 overflow-y-auto scroll-smooth\"]/descendant::a"));
							for(WebElement sndsublink: secsubcatrgy) {
								WebElement scndeachlist = sndsublink;
								action.moveToElement(scndeachlist).perform();
								String scnsubele = scndeachlist.getText();
								System.out.println(scnsubele);
							}
							System.out.println();
				}
				System.out.println();
			 }
			 System.out.println();
		}
	
	}
