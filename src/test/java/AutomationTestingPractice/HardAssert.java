package AutomationTestingPractice;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssert {

	String exptitle="vtiger CRM 5";
	
	@Test
	public void m1() {
		
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("http://localhost:8888/");
		
		String title = driver.getTitle();
		System.out.println(title);
		
		Assert.assertEquals(title, exptitle);
		
	}
	
	@Test
	public void m2() {
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("http://localhost:8888/");
		
		String title = driver.getTitle();
		System.out.println(title);
		
		Assert.assertSame(title, exptitle, "expected vtiger in exp title");
		
	}
	
	@Test
	public void m3() {
		
		int a=10;
		
		System.out.println(" -- 1 -- ");
		System.out.println(" -- 2 -- ");
		Assert.assertNotNull(a);
		System.out.println(" -- 3 -- ");
		Assert.assertNull(a);
		System.out.println(" -- 4 --");
		
	}
	
	@Test
	public void m4() {
		
		System.out.println(" -- 1 --");
		System.out.println(" -- 2 --");
		Assert.assertEquals("A", "B");
		System.out.println(" -- 3 --");
		System.out.println(" -- 4 --");
	}
	
	@Test
	public void m5() {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("http://localhost:8888/");
		
		String title = driver.getTitle();
		System.out.println(title);
		
		
		Assert.assertTrue(exptitle.equals(title));
		
	}
	
}
