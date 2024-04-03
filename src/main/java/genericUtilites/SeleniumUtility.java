package genericUtilites;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * This class consists of generic methods related to selenium web driver
 * @author Gayathri_93
 *
 */

public class SeleniumUtility {
	/**
	 * This method will maximize the window
	 * @param driver
	 */
	
	public void maximizewindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * This method will minimize the window
	 * @param driver
	 */
	
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}

	/**
	 * This method will add 10 sec of implicitly wait
	 * @param driver
	 */
	public void addImplicitlywait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	/**
	 * This method will wait for 10 seconds for a web element to be visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This method will handle drop down by index
	 * @param element
	 * @param index
	 */
	public void handledropDown(WebElement element, int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	
	/**
	 * This method will handle drop down by value
	 * @param element
	 * @param value
	 */
	public void handleDropDown(WebElement element, String value)
	{
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	/**
	 * This method will handle drop down by visible text
	 * @param text
	 * @param element
	 */
	public void handlingDropDown(String text, WebElement element)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	/**
	 * This method will perform mouse hover action on a web element
	 * @param driver
	 * @param element
	 */
	public void mouseHoverAction(WebDriver driver, WebElement element)
		{
			Actions act = new Actions(driver);
			act.moveToElement(element).perform();
		}
	/**
	 * This method will perform right click actions
	 * @param driver1
	 */
	public void rightclickAction(WebDriver driver1)
	{
		Actions act = new Actions(driver1);
		act.contextClick().perform();
	}
	/**
	 * This method will perform double click actions
	 * @param driver
	 */
	public void doubleClickAction(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.doubleClick().perform();
	}
	/**
	 * This method will perform drag and drop actions
	 * @param driver
	 * @param src
	 * @param dst
	 */
	public void dragAndDropAction(WebDriver driver, WebElement src, WebElement dst)
	
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(src, dst).perform();
		
	}
	/**
	 *  This method will scroll down by 500 units
	 * @param driver
	 */
	public void scrollDownAction(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("Window.scrollBy(500);", "");
		
	}
	/**
	 * This method will scroll up by 500 units
	 * @param driver
	 */
	public void scrollUpAction(WebDriver driver)
	
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("Window.scrollBy(0,-500);", "");
		
	}
	/**
	 * This method will scroll to a particular web element
	 * @param driver
	 * @param element
	 */
	public void scrollToElement(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.scrollToElement(element).perform();
	}
	/**
	 * This method will handle frames by index
	 * @param driver
	 * @param frameIndex
	 */
	public void handleFrame(WebDriver driver, int frameIndex)
	{
		driver.switchTo().frame(frameIndex);
	}
	/**
	 * This method will handle frames by name or id
	 * @param driver
	 * @param nameorId
	 */
	public void handleFrame(WebDriver driver, String nameorId)
	{
		driver.switchTo().frame(nameorId);
	}
	/**
	 * This method will handle frames by Frame element
	 * @param driver
	 * @param nameorId
	 */
	public void handleFrame(WebDriver driver, WebElement element)
	{
		driver.switchTo().frame(element);
	}
	/**
	 * This method will accept the alert pop up
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	/**
	 * This method will cancel the alert pop up
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
    /**
     * This method will enter text into the alert pop up
     * @param driver
     * @param text
     */
	public void enterTextAlert(WebDriver driver, String text)
	{
		driver.switchTo().alert().sendKeys(text);
	}
	/**
	 * This method will capture the alert text and return to caller
	 * @param driver
	 */
	public void getAlertText(WebDriver driver)
	{
		driver.switchTo().alert().getText();
	}
	
	public String caputureScreenShot(WebDriver driver, String ScreenshotName) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(".\\ScreenShots\\"+ ScreenshotName +".png");
		
		Files.copy(src, dst);
		
		return dst.getAbsolutePath();  //used for extent reports
		
	}
	
	
	
	
	
	
	
	
	
	
}






































