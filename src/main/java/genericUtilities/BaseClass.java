package genericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import objectRepository.HomePage;
import objectRepository.LoginPage;

public class BaseClass {

	public DatabaseUtils dLibs= new DatabaseUtils();
	public ExcelUtils eLibs= new ExcelUtils();
	public FileUtils fLibs=new FileUtils();
	public WebDriverUtils wLibs=new WebDriverUtils();
	public JavaUtils jLibs=new JavaUtils();
	
	
	public WebDriver driver;
//	public static WebDriver sdriver;
	public static ThreadLocal<WebDriver> wdriver= new ThreadLocal<WebDriver>();
	
	@BeforeSuite(alwaysRun = true)
	public void connectDB() {
		
		System.out.println(" -- connected to DB --");
		
	}
	
//	@Parameters("BROWSER")
	
	@BeforeClass(alwaysRun = true)
	public void connectToBrowser() throws Exception {
	
		
		String BROWSER = fLibs.readDataFromPropertyFile("browser");
		String URL = fLibs.readDataFromPropertyFile("url");
		
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver= new ChromeDriver();
		}else if(BROWSER.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}else if(BROWSER.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "C:\\drivers\\msedgedriver.exe");
			driver= new EdgeDriver();
		}
		
		wdriver.set(driver);
		
		wLibs.maximizeWindow(driver);
		wLibs.waitForPageLoad(driver);
		
		driver.get(URL);
		
	}
	
	@BeforeMethod(alwaysRun = true)
	public void login() throws Exception {
		
		String USERNAME = fLibs.readDataFromPropertyFile("username");
		String PASSWORD = fLibs.readDataFromPropertyFile("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.loginPageBL(USERNAME, PASSWORD);
	
		System.out.println(" -- logged into application --");
		
	}
	
	@AfterMethod(alwaysRun = true)
	public void signout() {
		
		HomePage hp = new HomePage(driver);
		hp.clickOnSignOut(driver);
		
		System.out.println(" -- signed out of application -- ");
		
	}
	
	@AfterClass(alwaysRun = true)
	public void closeBrowser() {
		
		driver.quit();
	
		System.out.println(" -- browser closed -- ");
		
	}
	
	@AfterSuite(alwaysRun = true)
	public void disconnectDB() {
		
		System.out.println(" -- disconnected the DB -- ");
		
	}
	
}
