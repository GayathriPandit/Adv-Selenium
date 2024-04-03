package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scenario4WithDDT 
{
	public static void main(String[] args) throws IOException, Throwable 
	{
		/*read data from property file*/
		FileInputStream fisp = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p = new Properties();
		p.load(fisp);
		
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		
		//read data from excel file
		FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fise);
		
		String ORGNAME = wb.getSheet("Organizations").getRow(1).getCell(2).getStringCellValue();
		
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
		  
		  Actions act = new Actions(driver);
		  act.moveToElement(ele).perform();
		  
		  Thread.sleep(1000);
		  
		  driver.findElement(By.linkText("Sign Out")).click();
		  
		  //Step 8: Close the Browser
		  driver.quit();
		
	
	
	}

}
