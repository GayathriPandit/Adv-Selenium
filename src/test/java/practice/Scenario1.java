package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scenario1
{
	public static void main(String[] args) throws Throwable 
	{		
	   //19-02-24
	   //Step 1: Launch the Browser
	   WebDriver driver = new ChromeDriver();
	   driver.get("http://localhost:8888/");
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   	   
	   //Step 2: Login to Application
	   driver.findElement(By.name("user_name")).sendKeys("admin");
	   driver.findElement(By.name("user_password")).sendKeys("admin");
	   driver.findElement(By.id("submitButton")).click();
	   
	   //Step 3: Navigate to contact Link
	   driver.findElement(By.linkText("Contacts")).click();
	   
	   //Step 4: Click on create Contact Look up Image
	   driver.findElement(By.xpath("//img[@alt=\"Create Contact...\"]")).click();
	   
	   //Step 5; Create Contact with mandatory fields and save
	   driver.findElement(By.name("lastname")).sendKeys("Gayathri");
	   driver.findElement(By.xpath("//input[@class=\"crmbutton small save\"]")).click();
	   //driver.findElement(By.xpath("//input[@title=\'Save [Alt+S]\']")).click();
	   
	   //Step 6: Validate for Contact
	   String contactHeader = driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
	   System.out.println(contactHeader);
	   
	   if(contactHeader.contains("Gayathri"))
	   {
		   System.out.println("PASS");
	   }
	   else
	   {
		   System.out.println("FAIL");
	   }
	   
	   //Step 7: Logout of App
	  WebElement ele = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
	  
	  Actions act = new Actions(driver);
	  act.moveToElement(ele).perform();
	  
	  Thread.sleep(1000);
	  
	  driver.findElement(By.linkText("Sign Out")).click();
	  
	  //Step 8: Close the Browser
	  driver.quit();
	
	
	}

}
