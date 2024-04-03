package practice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import genericUtilites.ExcelFileUtility;
import genericUtilites.ProprtyFileUtility;
import genericUtilites.SeleniumUtility;

public class Scenario2WithDDTAndGU {

	public static void main(String[] args) throws Throwable 
	{
		//Create Object of All Utility Classes
		ProprtyFileUtility pUtil = new ProprtyFileUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		SeleniumUtility sUtil = new SeleniumUtility();
				
		/*read data from property file*/
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		

		/*read data from excel file*/
		String PRODUCTNAME = eUtil.readDataFromExcel("Product", 1, 2);
		
		//Step 1: Launch the browser
				WebDriver driver = new EdgeDriver();
				sUtil.maximizewindow(driver);
				sUtil.addImplicitlywait(driver);
				
				driver.get(URL);
				
				//Step 2: Login to Application
				
				driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				driver.findElement(By.id("submitButton")).click();
				
				 //Step 3: Navigate to product link
				driver.findElement(By.linkText("Products")).click();
		
				//Step 4: Click on Create Product Look up image
				driver.findElement(By.xpath("//img[@alt=\"Create Product...\"]")).click();
		
				//Step 5; Create Contact with mandatory fields and save
			  	driver.findElement(By.name("productname")).sendKeys(PRODUCTNAME);
				driver.findElement(By.xpath("//input[@class=\"crmbutton small save\"]")).click();
		
				//Step 6: Validate for Contact
				String productHeader = driver.findElement(By.xpath("//span[@class=\"lvtHeaderText\"]")).getText();
				System.out.println(productHeader);
				   
				   if(productHeader.contains(PRODUCTNAME))
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
