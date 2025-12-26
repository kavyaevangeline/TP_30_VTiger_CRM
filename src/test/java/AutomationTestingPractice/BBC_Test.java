package AutomationTestingPractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BBC_Test {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://www.bbc.com/sport/olympics/paris-2024/medals");
		
		//click on medal result
		driver.findElement(By.linkText("Medal results")).click();
		
		driver.findElement(By.id("discipline-selector")).click();
		
		//drop down
		WebElement dropdown = driver.findElement(By.id("discipline-selector"));
		
		Select obj=new Select(dropdown);
		 List<WebElement> option =obj.getOptions();//returns list of webelement
		 
		List<WebElement> medals;
		
//		findElements() will not throw an exception, even if it finds 0 elements.
	
		    	  for(int i=0;i<option.size();i++) {
		  			obj.selectByIndex(i);
		  			System.out.println("Clicked: " + option.get(i).getText());
		  			
		  				medals=driver.findElements(By.xpath("//div[@class='ssrcss-7dafha-DesktopNames e1dg50ic3']/div[contains(@class,'SecondaryName')]"));
		  			if(medals.isEmpty()) {
		  				medals=driver.findElements(By.xpath("//div[@class='ssrcss-7dafha-DesktopNames e1dg50ic3']/div[contains(@class,'PrimaryName')]"));
		  			}
		  			
//		  				for (int j = 0; j < 3; j++) {//got array index out of bound exception
		  		            if(medals.size()>=3){
		  		                System.out.println("Gold Medal: "+medals.get(0).getText());//gettext wont work on list of webelement
		  		            
		  		                System.out.println("Silver Medal: "+medals.get(1).getText());
		  		          
		  		                System.out.println("Bronze Medal: "+medals.get(2).getText());

		  		} System.out.println("-------------");
		  		    }
		  				}}

		  		   
		 

	

