package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import genericUtilites.ExcelFileUtility;
import genericUtilites.ProprtyFileUtility;
import genericUtilites.SeleniumUtility;

public class Scenario4WithDDTAndGU 
{
	public static void main(String[] args) throws Throwable {
		//Create Object of All Utility Classes
				ProprtyFileUtility pUtil = new ProprtyFileUtility();
				ExcelFileUtility eUtil = new ExcelFileUtility();
				SeleniumUtility sUtil = new SeleniumUtility();
				
				/*read data from property file*/
				String URL = pUtil.readDataFromPropertyFile("url");
				String USERNAME = pUtil.readDataFromPropertyFile("username");
				String PASSWORD = pUtil.readDataFromPropertyFile("password");
				
				/*Read data from excel file*/
				 String ORGNAME = eUtil.readDataFromExcel("Organizations", 1, 2);
					//Step 1: Launch the browser
					WebDriver driver = new EdgeDriver();
					driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
					
					driver.get(URL);
					
					//Step 2: Login to the Application
					driver.findElement(By.name("user_name")).sendKeys(USERNAME);
					driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
					driver.findElement(By.id("submitButton")).click();
					
					//Step 3: Navigate to Organization Link
					driver.findElement(By.linkText("Organizations")).click();
					
					//Step 4: Click on Create Organization Look up image
					driver.findElement(By.xpath("//img[@title=\"Create Organization...\"]")).click();
					
					//Step 5: Create Organization with mandatory fields and save
					driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
					driver.findElement(By.xpath("//input[@class=\"crmbutton small save\"]")).click();
					
					//Step 6: Validate for organization
					String orgHeader = driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
					System.out.println(orgHeader);
					
					if(orgHeader.contains(ORGNAME))
					{
						System.out.println("PASS");
					}
					else
					{
						System.out.println("FAIL");
					}
					
					//Step 7: Logout of app
					WebElement ele = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
					  
					sUtil.mouseHoverAction(driver, ele);
					  
					  Thread.sleep(1000);
					  
					  driver.findElement(By.linkText("Sign Out")).click();
					  
					  //Step 8: Close the Browser
					  driver.quit();
	}

}
