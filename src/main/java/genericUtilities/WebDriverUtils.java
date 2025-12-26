package genericUtilities;


import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtils {
	
	//maximize window
	
	/**
	 * This methos is used to maximize window
	 * @author Kavya
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		
		driver.manage().window().maximize();
	}
	
	//implicit wait
	
	/**
	 * This method is used to wait for page to load
	 * @author Kavya
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver) {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	//explicit wait
	
	/**
	 * This method is used to wait until element is visible
	 * @author Kavya
	 * @param driver
	 * @param seconds
	 * @param actualtitle
	 */
	public void waitUntilEleToBeVisible(WebDriver driver,int seconds, WebElement actualtitle) {
		
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.visibilityOf(actualtitle));
	}
	
	/**
	 * This method is used to wait until element is clickable
	 * @author Kavya
	 * @param driver
	 * @param seconds
	 * @param element
	 */
	public void waitUntillEleToBeClickable(WebDriver driver, int seconds, WebElement element) {
		
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	//select class
	
	
	/**
	 * This method is used to work on drop down
	 * @author Kavya
	 * @param element
	 * @return
	 */
	public Select dropDown(WebElement element) {
		
		Select sel= new Select(element);
		return sel;
		
	}
	
	/**
	 * This method is used to select drop down by value
	 * @author Kavya
	 * @param sel
	 * @param value
	 */
	public void dropDownUsingValue(Select sel, String value) {
		
		sel.selectByValue(value);
	}
	
	/**
	 * This method is used to select element by index
	 * @author Kavya
	 * @param element
	 * @param value
	 */
	public void dropDownUsingIndex(WebElement element, int value) {
		
		dropDown(element).selectByIndex(value);
	}
	
	/**
	 * This method is used to select element by visible text
	 * @author Kavya
	 * @param element
	 * @param value
	 */
	public void dropDownUsingVisibleText(WebElement element, String value) {
		
		dropDown(element).selectByVisibleText(value);
	}
	
	/**
	 * This method is used to select element by contains visible text
	 * @author Kavya G
	 * @param element
	 * @param value
	 */
	public void dropDownUsingContainsVisibleText(WebElement element, String value) {
		
		dropDown(element).selectByContainsVisibleText(value);
		
	}
	
	//action class
	
	/**
	 * This method is used to work on action class
	 * @author Kavya
	 * @param driver
	 * @return
	 */
	public Actions action(WebDriver driver) {
		
		Actions action=new Actions(driver);
		return action;
	}
	
	/**
	 * This method is used to do mouseHover action
	 * @author Kavya
	 * @param driver
	 * @param element
	 */
	public void mouseHover(WebDriver driver, WebElement element) {
		
		action(driver).moveToElement(element).perform();
		
	}
	
	/**
	 * This method is used to work on mouseHover click on element action
	 * @author Kavya
	 * @param driver
	 * @param element
	 */
	public void mouseHoverAndClickOnEle(WebDriver driver, WebElement element) {
		
		action(driver).moveToElement(element).click(element).perform();
		
	}
	
	/**
	 * This method is used to work on mouseHover drag and drop action
	 * @author Kavya
	 * @param driver
	 * @param src
	 * @param desc
	 */
	public void mouseHoverDragAndDropOnEle(WebDriver driver, WebElement src, WebElement desc) {
		
		action(driver).dragAndDrop(src, desc).perform();
	}
	
	/**
	 * This method is used to scroll web page
	 * @author Kavya
	 * @param driver
	 * @param x
	 * @param y
	 */
	public void scrollWebPage(WebDriver driver, int x, int y) {
		
		action(driver).scrollByAmount(x, y).perform();
		
	}
	
	/**
	 * This method is used to double click on element
	 * @author Kavya
	 * @param driver
	 */
	public void doubleClick(WebDriver driver) {
		
		action(driver).doubleClick().perform();
	}
	
	/**
	 * This method is used to double click on element
	 * @author Kavya
	 * @param driver
	 * @param element
	 */
	public void doubleClickOnElement(WebDriver driver, WebElement element) {
		
		action(driver).doubleClick(element).perform();
		
	}
	
	/**
	 * This method is used to right click on element on web page
	 * @author Kavya
	 * @param driver
	 */
	public void rightClickOnOnWebPage(WebDriver driver) {
		
		action(driver).contextClick().perform();
		
	}
	
	/**
	 * This method is used right click on element
	 * @author Kavya
	 * @param driver
	 * @param elemet
	 */
	public void rightClickOnEle(WebDriver driver, WebElement elemet) {
		
		action(driver).contextClick(elemet).perform();
		
	}
	
	/**
	 * This method is used to click and hold
	 * @author Kavya
	 * @param driver
	 * @param element
	 */
	public void clickAndHold(WebDriver driver, WebElement element) {
		
		action(driver).clickAndHold(element).perform();
		
	}
	
	/**
	 * This method is used to click hold and release
	 * @author Kavya
	 * @param driver
	 * @param element
	 */
	public void clickHoldAndRelease(WebDriver driver, WebElement element) {
		
		action(driver).clickAndHold(element).release().perform();
	}
	
	//handling multiple window
	
	/**
	 * This method is used to switch to child window
	 * @author Kavya
	 * @param driver
	 * @param exptitle
	 */
	public void switchToWindow(WebDriver driver, String exptitle) {
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itt = windows.iterator();
		while(itt.hasNext()) {
			String currentwin = itt.next();
			String actualtitle = driver.switchTo().window(currentwin).getTitle();
			if(actualtitle.contains(exptitle)) {
				break;
			}
		}
	}
	
	/**
	 * This method is used to switch to frame by frame index
	 * @author Kavya
	 * @param driver
	 * @param index
	 */
	public void switchToChildFrame(WebDriver driver, int index) {
		
		driver.switchTo().frame(index);
		
	}
	
	/**
	 * This method is used to switch to frame by frame name
	 * @author Kavya
	 * @param driver
	 * @param name
	 */
	public void SwitchToChildFrame(WebDriver driver, String name) {
		
		driver.switchTo().frame(name);
		
	}
	
	/**
	 * This method is used to switch frame by element
	 * @author kavya
	 * @param driver
	 * @param element
	 */
	public void SwitchToChildFrame(WebDriver driver, WebElement element) {
		
		driver.switchTo().frame(element);
		
	}
	
	/**
	 * This method is used to switch to parent frame
	 * @author Kavya
	 * @param driver
	 */
	public void switchToParentFrame(WebDriver driver) {
		
		driver.switchTo().parentFrame();
		
	}
	
	/**
	 * This method is used to wseitch to main frame
	 * @author Kavya
	 * @param driver
	 */
	public void switchToMainFrame(WebDriver driver) {
		
		driver.switchTo().defaultContent();
		
	}
	
	//alert popups
	
	/**
	 * This method is used to accept alert
	 * @author Kavya
	 * @param driver
	 */
	public void acceptAlertPopup(WebDriver driver) {
		
		driver.switchTo().alert().accept();
		
	}
	
	/**
	 * This method is used to dismiss alert
	 * @author Kavya
	 * @param driver
	 */
	public void dismissAlertPopup(WebDriver driver) {
		
		driver.switchTo().alert().dismiss();
		
	}
	
	/**
	 * This method is used to get text from alert popup
	 * @author Kavya
	 * @param driver
	 */
	public void getTextFromAlertPopup(WebDriver driver) {
		
		driver.switchTo().alert().getText();
		
	}
	
	/**
	 * This method is used to enter value in to alert pop up
	 * @author Kavya
	 * @param driver
	 * @param value
	 */
	public void enterValueInToAlertTextfield(WebDriver driver, String value) {
		
		driver.switchTo().alert().sendKeys(value);
		
	}
	
	//javascriptexecutor
	
	/**
	 * This method is used for javascriptexecutor
	 * @author Kavya
	 * @param driver
	 * @return
	 */
	public JavascriptExecutor javaScriptExecutor(WebDriver driver) {
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		return js;
	}
	
	//scroll by height
	
	/**
	 * This method is used to scroll height
	 * @author Kavya
	 * @param driver
	 */
	public void scrollHeight(WebDriver driver) {
		
		javaScriptExecutor(driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
	}
	
	//scroll till element
	
	/**
	 * This method id used to scroll until element is visible
	 * @author Kavya
	 * @param driver
	 * @param element
	 */
	public void scrollUntilEleIsVisibleUsingJSE(WebDriver driver, WebElement element) {
		
		javaScriptExecutor(driver).executeScript("arguments[0].scrollIntoView()", element);
		
	}
	
	//click on element
	
	/**
	 * This method is used click on the element 
	 * @author Kavya
	 * @param driver
	 * @param element
	 */
	public void clickOnElementUsingJSE(WebDriver driver, WebElement element) {
		
		javaScriptExecutor(driver).executeScript("arguments[0].click()", element);
	}
	
	//send keys
	
	/**
	 * this method is used to enter value in textfield
	 * @author Kavya
	 * @param driver
	 * @param element
	 * @param value
	 */
	public void enterValueIntoTextFieldUsingJSE(WebDriver driver, WebElement element, String value) {
		
		javaScriptExecutor(driver).executeScript("arguments[0].sendkeys(value)", element, value);
		
	}
	
	/**
	 *  this method is used to scroll to element using X and Y coordinate
	 *  @author Kavya
	 * @param driver
	 * @param element
	 */
	
	public void scrollToEleUsingXYCoOrdinate(WebDriver driver, WebElement element) {
		
	  Point loc = element.getLocation();
	  int x= loc.getX();
	  int y=loc.getY();
	javaScriptExecutor(driver).executeScript("window.scrollBy("+x+","+y+")");
	}
}
